package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by kanaiza on 11/2/16.
 */
@Entity
public class AccomodationFee extends AbstractModel {
    @ManyToOne
    private StudentProfile profile;
    private Long amount;

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
