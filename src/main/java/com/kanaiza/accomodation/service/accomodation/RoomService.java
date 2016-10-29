package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Room;
import org.springframework.data.domain.Page;

/**
 * Created by wladek on 9/22/16.
 */
public interface RoomService {
    public Room create(Room room);
    public Room findById(Long id);
    public Page<Room> findByBlock(Long blockId , int page , int size);
    public Room update(Room room);
    public void delete(Room room);
}
