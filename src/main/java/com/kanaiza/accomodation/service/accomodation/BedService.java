package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Bed;
import com.kanaiza.accomodation.domain.accomodation.RoomItem;
import com.kanaiza.accomodation.domain.enumeration.BedStatus;

import java.util.List;



public interface BedService {
    public Bed create(Bed bed);
    public Bed findOne(Long bed);
    public Bed findById(Long id);
    public List<Bed> findAll();
    public Bed update(Bed bed);
    public void delete(Bed bed);
    public String bookBed(Bed bed);
    public Bed getStudentBed(Long studentId);
    public List<RoomItem> getStudentRoomItems(boolean getAll);
    public void cancelBooking(Long studentId);
    public String clearBed(Long bedId);
    public List<Bed> findByStatusAndZoneCode(BedStatus bedStatus , String zoneCode);
}
