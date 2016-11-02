package com.kanaiza.accomodation.service.student;

import com.kanaiza.accomodation.domain.User;
import com.kanaiza.accomodation.domain.accomodation.*;
import com.kanaiza.accomodation.domain.enumeration.BedStatus;
import com.kanaiza.accomodation.domain.enumeration.DamageType;
import com.kanaiza.accomodation.domain.enumeration.DisciplineType;
import com.kanaiza.accomodation.domain.enumeration.RoomItemClearStatus;
import com.kanaiza.accomodation.repository.accomodation.*;
import com.kanaiza.accomodation.service.UserDetailsImpl;
import com.kanaiza.accomodation.service.UserService;
import com.kanaiza.accomodation.service.accomodation.DamageService;
import com.kanaiza.accomodation.service.accomodation.DisciplineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wladek on 9/25/16.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    UserService userService;
    @Autowired
    RoomItemRepo roomItemRepo;
    @Autowired
    ItemCostRepo itemCostRepo;
    @Autowired
    RoomTransferRepo transferRepo;
    @Autowired
    DisciplineService disciplineService;
    @Autowired
    BedRepo bedRepo;
    @Autowired
    DamageService damageService;

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public StudentProfile loadProfile(Long id) {
        User student = getCurrentStudent(id);

        StudentProfile profile = student.getProfile();

        if (profile == null){
            return null;
        }else{
            return profile;
        }
    }

    @Override
    public User getCurrentStudent(Long id) {
        return userService.findById(id);
    }

    @Override
    public StudentProfile createProfile(StudentProfile studentProfile) {
        User student = getCurrentUser();

        StudentProfile profile = student.getProfile();

        if (profile == null){

            profile = studentProfile;
            profile.setStudent(student);

        }else {

            profile.setGender(studentProfile.getGender());
            profile.setCourse(studentProfile.getCourse());
            profile.setDepartment(studentProfile.getDepartment());
            profile.setStudentRegNo(studentProfile.getStudentRegNo());
            profile.setPhoneNumber(studentProfile.getPhoneNumber());
        }

        return profileRepo.save(profile);
    }

    @Override
    public Page<StudentProfile> getAll(int page, int size) {
        page = page -1;
        PageRequest pageRequest = new PageRequest(page , size);
        return profileRepo.findAll(pageRequest);
    }

    @Override
    public Page<StudentProfile> getByStudentNumber(String studentNumber, int page, int size) {
        page = page -1;
        PageRequest pageRequest = new PageRequest(page ,size);
        return profileRepo.findByStudentRegNo(studentNumber, pageRequest);
    }

    @Override
    public StudentProfile loadProfileById(Long profileId) {
        return profileRepo.findOne(profileId);
    }

    @Override
    public List<RoomItem> getStudentRoomItems(Long userId, boolean getAll) {
        User student = userService.findById(userId);


        if (getAll) {
            return roomItemRepo.findByStudent(student);
        } else {
            List<RoomItem> roomItems = new ArrayList<>();

            roomItems.clear();
            roomItems.addAll(roomItemRepo.findByClearStatusAndStudent(RoomItemClearStatus.ASSIGNED, student));
            roomItems.addAll(roomItemRepo.findByClearStatusAndStudent(RoomItemClearStatus.ISSUED, student));

            return roomItems;
        }
    }

    @Override
    public String issueItem(Long itemId) {
        RoomItem roomItem = roomItemRepo.findOne(itemId);

        RoomItemCost itemCost = itemCostRepo.findByItemName(roomItem.getItemName());

        if (itemCost.getTotalAvailable() > itemCost.getTotalIssued()){

            roomItem.setClearStatus(RoomItemClearStatus.ISSUED);

            Long issued = itemCost.getTotalIssued() + 1;
            itemCost.setTotalIssued(issued);

            roomItemRepo.save(roomItem);

            itemCostRepo.save(itemCost);

            return "SUCCESS";
        }

        return "No "+roomItem.getItemName() +" available in stock";
    }

    /**
     *
     * @param roomTransfer
     * @return
     */
    @Override
    public RoomTransfer makeRequest(RoomTransfer roomTransfer) {
        StudentProfile studentProfile = profileRepo.findOne(roomTransfer.getProfileId());
        roomTransfer.setProfile(studentProfile);
        return transferRepo.save(roomTransfer);
    }

    /**
     *
     * @param disciplinary
     * @return string response
     */
    @Override
    public String setDiscipline(Disciplinary disciplinary) {

        logger.info("++++++ SETTING STUDENT DISCIPLINARY ++++++ ");

        Disciplinary newDisciplinary = disciplineService.create(disciplinary);

        if (newDisciplinary == null){
            return "There was an error while processing student details. Please try again later";
        }

        User student = loadProfileById(disciplinary.getProfileId()).getStudent();

        if(disciplinary.getType() == DisciplineType.COOKING) {
            Bed studentBed = student.getBed();
            studentBed.setStatus(BedStatus.AVAILABLE);
            bedRepo.save(studentBed);
        }else {

            Long roomCost = student.getBed().getRoom().getCost();

            setDamageCost(student, DamageType.COHABITING, "Charged for cohabiting" , roomCost);
        }


        return "Discipline record saved.";
    }

    /**
     *
     * @param roomItem
     * @param studentProfileId
     */
    @Override
    public void clearStudentRoomItem(RoomItem roomItem, Long studentProfileId) {

        RoomItem itemInDb = roomItemRepo.findOne(roomItem.getId());

        itemInDb.setItemCondition(roomItem.getItemCondition());
        itemInDb.setClearStatus(roomItem.getClearStatus());
        itemInDb = roomItemRepo.save(itemInDb);

        if (itemInDb.getClearStatus() == RoomItemClearStatus.NOT_CLEARED){

            String damageDescription = "Charged for";
            String itemName = itemInDb.getItemName().toString().toLowerCase();

            switch (itemInDb.getItemCondition()){
                case DAMAGED:
                    damageDescription = damageDescription + " damaging "+itemName;
                    break;
                case LOST:
                    damageDescription = damageDescription + " losing "+itemName;
                    break;
                default:
                    break;

            }

            User student = loadProfileById(studentProfileId).getStudent();

            setDamageCost(student , DamageType.ROOM_ITEM,damageDescription , itemInDb.getCost());
        }
    }

    /**
     *
     * @param student
     * Charges student for cohabiting
     */
    public void setDamageCost(User student, DamageType damageType , String description , Long cost){
        Damage damage = new Damage();

        damage.setAmount(cost);
        damage.setProfile(student.getProfile());
        damage.setType(damageType);
        damage.setDescription(description);
        damage.setEffectiveDate(new Date());

        damageService.create(damage);

    }

    /**
     *
     * @return Student
     */
    public User getCurrentUser(){

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        return userDetails.getUser();
    }
}
