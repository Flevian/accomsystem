package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by kanaiza on 11/2/16.
 */
@Entity
public class AcademicFee extends AbstractModel {
    @ManyToOne
    private StudentProfile profile;
    private  Long paidFee;
    private Long expectedFee;

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }

    public Long getPaidFee() {
        return paidFee;
    }

    public void setPaidFee(Long paidFee) {
        this.paidFee = paidFee;
    }

    public Long getExpectedFee() {
        return expectedFee;
    }

    public void setExpectedFee(Long expectedFee) {
        this.expectedFee = expectedFee;
    }
}
