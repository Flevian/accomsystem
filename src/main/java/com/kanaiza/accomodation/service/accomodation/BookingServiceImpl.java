package com.kanaiza.accomodation.service.accomodation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    RoomService roomService;

    @Override
    public String bookRoom(Long bedId) {
        return null;
    }
}
