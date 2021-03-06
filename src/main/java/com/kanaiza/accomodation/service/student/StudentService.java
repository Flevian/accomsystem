package com.kanaiza.accomodation.service.student;

import com.kanaiza.accomodation.domain.User;
import com.kanaiza.accomodation.domain.accomodation.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by wladek on 9/25/16.
 */
public interface StudentService {
    public StudentProfile loadProfile(Long id);
    public User getCurrentStudent(Long id);
    public StudentProfile createProfile(StudentProfile studentProfile);
    public Page<StudentProfile> getAll(int page, int size);
    public Page<StudentProfile> getByStudentNumber(String studentNumber , int page, int size);
    public StudentProfile loadProfileById(Long profileId);
    public List<RoomItem> getStudentRoomItems(Long userId , boolean getAll);
    public String issueItem(Long itemId);
    public RoomTransfer makeRequest(RoomTransfer roomTransfer);
    public String setDiscipline(Disciplinary disciplinary);
    public void clearStudentRoomItem(RoomItem roomItem , Long studentProfileId);
}
