package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Bed;
import com.kanaiza.accomodation.domain.accomodation.Room;
import com.kanaiza.accomodation.domain.enumeration.BedStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kanaiza on 11/1/16.
 */
@Repository
public interface BedRepo extends JpaRepository<Bed , Long> {
    public List<Bed> findByStatusAndRoom(BedStatus status , Room room);
    public List<Bed> findByStatusAndZoneCode(BedStatus status , String zoneCode);
}