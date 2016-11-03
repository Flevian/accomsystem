package com.kanaiza.accomodation.repository;

import java.util.List;

/**
 * Created by kanaiza on 11/3/16.
 */
public interface CustomRepo {
    public List<String> getVacantBeds(String zoneCode,String gender);
}
