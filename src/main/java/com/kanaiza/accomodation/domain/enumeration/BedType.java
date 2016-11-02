package com.kanaiza.accomodation.domain.enumeration;
/**
 * Created by kanaiza on 10/28/16.
 */
public enum  BedType {
    UPPER("Upper"),
    LOWER("Lower");

    String name;

    BedType(String string) {
        this.name = string;
    }
}
