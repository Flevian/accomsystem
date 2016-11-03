package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.NonResident;
import com.kanaiza.accomodation.repository.NonResidentRepo;
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

    @Override
    public NonResident update(NonResident nonResident) {
        return null;
    }

    @Override
    public NonResident create(NonResident nonResident) {
        return nonResidentRepo.save(nonResident);
    }
}
