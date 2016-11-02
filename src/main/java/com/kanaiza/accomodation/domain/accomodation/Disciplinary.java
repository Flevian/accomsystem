package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;
import com.kanaiza.accomodation.domain.enumeration.DisciplineStatus;
import com.kanaiza.accomodation.domain.enumeration.DisciplineType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kanaiza on 10/29/16.
 */
@Entity
public class Disciplinary extends AbstractModel {
    @ManyToOne
    private StudentProfile profile;
    @Enumerated(EnumType.STRING)
    private DisciplineType type;
    @Enumerated(EnumType.ORDINAL)
    private DisciplineStatus status;
    @Column(columnDefinition = "text")
    private String description;
    private Date effectiveDate;
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DisciplineStatus getStatus() {
        return status;
    }

    public void setStatus(DisciplineStatus status) {
        this.status = status;
    }

    public DisciplineType getType() {
        return type;
    }

    public void setType(DisciplineType type) {
        this.type = type;
    }

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }

    /**
     * hold's student profile id
     */
    @Transient
    private Long profileId;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}

