package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.AccomodationFee;

import java.util.List;

/**
 * Created by kanaiza on 11/2/16.
 */
public interface AccomodationFeeService {
    public AccomodationFee create(AccomodationFee accomodationFee);
    public AccomodationFee findById(Long id);
    public List<AccomodationFee> findAll();
    public AccomodationFee update(AccomodationFee accomodationFee);
    public void delete(AccomodationFee accomodationFee);
}
