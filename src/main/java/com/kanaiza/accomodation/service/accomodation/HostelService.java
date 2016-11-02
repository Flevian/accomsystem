package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Hostel;

import java.util.List;



public interface HostelService {
    public Hostel create(Hostel hostel);
    public Hostel findById(Long id);
    public List<Hostel> findAll();
    public Hostel update(Hostel hostel);
    public void delete(Hostel hostel);
}
