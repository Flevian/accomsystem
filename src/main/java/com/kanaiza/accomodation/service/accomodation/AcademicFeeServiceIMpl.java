package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.AcademicFee;
import com.kanaiza.accomodation.repository.accomodation.AcademicFeeRepo;
import com.kanaiza.accomodation.repository.accomodation.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kanaiza on 11/2/16.
 */
@Service
@Transactional
public class AcademicFeeServiceIMpl implements AcademicFeeService {
    @Autowired
    AcademicFeeRepo academicFeeRepo;
    @Autowired
    ProfileRepo profileRepo;

    @Override
    public AcademicFee create(AcademicFee academicFee) {
        return academicFeeRepo.save(academicFee);
    }

    @Override
    public AcademicFee findById(Long id) {
        return academicFeeRepo.findOne(id);
    }

    @Override
    public List<AcademicFee> findAll() {
        return null;
    }

    @Override
    public AcademicFee update(AcademicFee academicFee) {
        AcademicFee academicFeeInDb = findById(academicFee.getId());
        academicFeeInDb.setPaidFee(academicFee.getPaidFee());
        academicFeeInDb.setExpectedFee(academicFee.getExpectedFee());
        return academicFeeRepo.save(academicFeeInDb);
    }

    @Override
    public void delete(AcademicFee academicFee) {

    }
}
