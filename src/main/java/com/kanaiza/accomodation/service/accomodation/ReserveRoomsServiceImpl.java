package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.ReserveRooms;
import com.kanaiza.accomodation.repository.accomodation.ReserveRoomsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kanaiza on 10/30/16.
 */
@Service
@Transactional
public class ReserveRoomsServiceImpl implements ReserveRoomsService {

    @Autowired
    ReserveRoomsRepo reserveRoomsRepo;
    @Autowired
    RoomService roomService;

    @Override
    public ReserveRooms create(ReserveRooms reserveRooms) {
        reserveRooms.setRoom(roomService.findById(reserveRooms.getRoomId()));
        return reserveRoomsRepo.save(reserveRooms);
    }

    @Override
    public ReserveRooms update(ReserveRooms reserveRooms) {
        ReserveRooms reserveRoomsInDb = findById(reserveRooms.getId());
        reserveRoomsInDb.setReserveRoomStatus(reserveRooms.getReserveRoomStatus());
        return reserveRoomsRepo.save(reserveRoomsInDb);
    }

    @Override
    public ReserveRooms findById(Long id) {

        return reserveRoomsRepo.findOne(id);
    }

    @Override
    public void delete(ReserveRooms reserveRooms) {

    }

    @Override
    public List<ReserveRooms> findAll() {
        return reserveRoomsRepo.findAll();
    }



    @Override
    public ReserveRooms findOne(Long reserveRooms) {
        return null;
    }
}
