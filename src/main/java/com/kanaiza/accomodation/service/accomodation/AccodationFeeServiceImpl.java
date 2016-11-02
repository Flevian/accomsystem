package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.AccomodationFee;
import com.kanaiza.accomodation.repository.accomodation.AccomodationFeeRepo;
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
public class AccodationFeeServiceImpl implements AccomodationFeeService {
    @Autowired
    AccomodationFeeRepo accomodationFeeRepo;
    @Autowired
    ProfileRepo profileRepo;

    @Override
    public AccomodationFee create(AccomodationFee accomodationFee) {
        return accomodationFeeRepo.save(accomodationFee);
    }

    @Override
    public AccomodationFee findById(Long id) {
        return accomodationFeeRepo.findOne(id);
    }

    @Override
    public List<AccomodationFee> findAll() {
        return null;
    }

    @Override
    public void delete(AccomodationFee accomodationFee) {

    }

    @Override
    public AccomodationFee update(AccomodationFee accomodationFee) {
        AccomodationFee accomodationFeeInDb = findById(accomodationFee.getId());
        accomodationFeeInDb.setAmount(accomodationFee.getAmount());
        return accomodationFeeRepo.save(accomodationFeeInDb);
    }
}
