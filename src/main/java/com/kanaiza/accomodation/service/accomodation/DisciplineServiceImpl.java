package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Bed;
import com.kanaiza.accomodation.domain.accomodation.Disciplinary;
import com.kanaiza.accomodation.domain.accomodation.StudentProfile;
import com.kanaiza.accomodation.domain.enumeration.BedStatus;
import com.kanaiza.accomodation.domain.enumeration.DisciplineStatus;
import com.kanaiza.accomodation.domain.enumeration.DisciplineType;
import com.kanaiza.accomodation.repository.accomodation.BedRepo;
import com.kanaiza.accomodation.repository.accomodation.DisciplinaryRepo;
import com.kanaiza.accomodation.repository.accomodation.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kanaiza on 10/29/16.
 */
@Service
@Transactional
public class DisciplineServiceImpl  implements DisciplineService{
    @Autowired
    DisciplinaryRepo disciplinaryRepo;
    @Autowired
    ProfileRepo profileRepo;

    @Override
    public Disciplinary create(Disciplinary disciplinary) {

        //Check if student id is provided.
        if(disciplinary.getProfileId()!=null) {

            /**
             * Find the students profile.
             */
            StudentProfile profile = profileRepo.findOne(disciplinary.getProfileId());

            /**
             * Assign the discipline case to the profile(student profile.)
             */
            disciplinary.setProfile(profile);


            disciplinary.setEffectiveDate(new Date());

            disciplinary.setStatus(DisciplineStatus.ACTIVE);

            if (disciplinary.getType() == DisciplineType.COOKING) {
                disciplinary.setDuration(1);
            } else {
                disciplinary.setDuration(0);
            }

        }
        //Save to database.
        return disciplinaryRepo.save(disciplinary);
    }

    @Override
    public Disciplinary update(Disciplinary disciplinary) {
        return null;
    }
}
