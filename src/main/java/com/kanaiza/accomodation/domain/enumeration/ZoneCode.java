package com.kanaiza.accomodation.domain.enumeration;

/**
 * Created by kanaiza on 10/28/16.
 */
public enum  ZoneCode {
    Z01("CBD"),
    Z02("Northern"),
    Z03("Southern"),
    Z04("Western"),
    Z05("Nakuru Town");

    protected String name;

    ZoneCode(String s) {
        this.name = s;
    }
}
