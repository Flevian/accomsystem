package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by kanaiza on 11/2/16.
 */
@Entity
public class NonResident extends AbstractModel{
    @ManyToOne(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    private StudentProfile profile;
    private String landLordFullName;
    private String landLordPhoneNumber;
    private String hostelName;
    private String location;
    private SemCount semCount;

    public StudentProfile getProfile() {
        return profile;
    }

    public void setProfile(StudentProfile profile) {
        this.profile = profile;
    }

    public String getLandLordFullName() {
        return landLordFullName;
    }

    public void setLandLordFullName(String landLordFullName) {
        this.landLordFullName = landLordFullName;
    }

    public String getLandLordPhoneNumber() {
        return landLordPhoneNumber;
    }

    public void setLandLordPhoneNumber(String landLordPhoneNumber) {
        this.landLordPhoneNumber = landLordPhoneNumber;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SemCount getSemCount() {
        return semCount;
    }

    public void setSemCount(SemCount semCount) {
        this.semCount = semCount;
    }
}
