package com.kanaiza.accomodation.domain.enumeration;
/**
 * Created by kanaiza on 10/28/16.
 */
public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String name;
    Gender(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }
}
