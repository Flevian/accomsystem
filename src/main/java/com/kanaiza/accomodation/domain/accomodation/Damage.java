package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;
import com.kanaiza.accomodation.domain.enumeration.DamageType;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by kanaiza on 10/30/16.
 */
@Entity
public class Damage extends AbstractModel {
    @ManyToOne
    private StudentProfile profile;
    @Enumerated(EnumType.ORDINAL)
    private DamageType type;
    @Column(columnDefinition = "text")
    private String description;
    private Date effectiveDate;
    private Long amount;

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DamageType getType() {
        return type;
    }

    public void setType(DamageType type) {
        this.type = type;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Transient
    private Long profileId;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
