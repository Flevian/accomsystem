package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Damage;
import com.kanaiza.accomodation.domain.accomodation.StudentProfile;
import com.kanaiza.accomodation.repository.accomodation.DamageRepo;
import com.kanaiza.accomodation.repository.accomodation.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by kanaiza on 10/30/16.
 */
@Service
@Transactional
public class DamageServiceImpl implements DamageService {
    @Autowired
    DamageRepo damageRepo;
    @Autowired
    ProfileRepo profileRepo;

    @Override
    public Damage create(Damage damage) {
        return damageRepo.save(damage);
    }

    @Override
    public Damage update(Damage damage) {
        return null;
    }
}
