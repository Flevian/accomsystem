package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.ReserveRooms;
import com.kanaiza.accomodation.domain.accomodation.Room;
import org.springframework.data.domain.Page;



public interface RoomService {
    public Room create(Room room);
    public Room findOne(Long room);
    public Room findById(Long id);
    public Page<Room> findByBlock(Long blockId , int page , int size);
    public Room update(Room room);
    public void delete(Room room);


}
