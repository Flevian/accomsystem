package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kanaiza on 10/28/16.
 */
@Entity
public class Zone extends AbstractModel{
    @NotEmpty(message = "Name must be provided")
    private String name;
    @NotEmpty(message = "Provide zone code")
    private String code;

    @OneToMany(mappedBy = "zone" , fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Hostel> hostels = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Hostel> getHostels() {
        return hostels;
    }

    public void setHostels(Set<Hostel> hostels) {
        this.hostels = hostels;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
