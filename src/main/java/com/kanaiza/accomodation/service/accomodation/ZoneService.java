package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Zone;

import java.util.List;



public interface ZoneService {
    public Zone create(Zone zone);
    public Zone findById(Long id);
    public List<Zone> findAll();
    public Zone update(Zone zone);
    public void delete(Zone zone);
}
