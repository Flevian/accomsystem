package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.AcademicFee;

import java.util.List;

/**
 * Created by kanaiza on 11/2/16.
 */
public interface AcademicFeeService {

    public AcademicFee create(AcademicFee academicFee);
    public AcademicFee findById(Long id);
    public List<AcademicFee> findAll();
    public AcademicFee update(AcademicFee academicFee);
    public void delete(AcademicFee academicFee);
}
