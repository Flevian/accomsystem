package com.kanaiza.accomodation.domain.enumeration;

/**
 * Created by kanaiza on 10/28/16.
 */
public enum RoomType {
    SINGLE("Single"),
    DOUBLE("Double"),
    TRIPLE("Triple"),
    QUADRUPLE("Quadruple");

    String name;

    RoomType(String single) {
        this.name = single;
    }
}
