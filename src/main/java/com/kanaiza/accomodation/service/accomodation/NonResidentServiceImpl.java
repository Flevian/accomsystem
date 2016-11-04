package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.NonResident;
import com.kanaiza.accomodation.domain.accomodation.StudentProfile;
import com.kanaiza.accomodation.repository.NonResidentRepo;
import com.kanaiza.accomodation.repository.accomodation.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by kanaiza on 11/3/16.
 */
@Service
@Transactional
public class NonResidentServiceImpl implements NonResidentService {
    @Autowired
    NonResidentRepo nonResidentRepo;
    @Autowired
    ProfileRepo profileRepo;

    @Override
    public NonResident update(NonResident nonResident) {
        return null;
    }

    @Override
    public NonResident create(NonResident nonResident) {
        //Check if student id is provided.
        if (nonResident.getProfileId() != null) {

            /**
             * Find the students profile.
             */
            StudentProfile profile = profileRepo.findOne(nonResident.getProfileId());

            /**
             * Assign the discipline case to the profile(student profile.)
             */
            nonResident.setProfile(profile);

        }
        return nonResidentRepo.save(nonResident);
    }
}
