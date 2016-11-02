package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.ReserveRooms;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by kanaiza on 10/30/16.
 */
public interface ReserveRoomsService {
    public ReserveRooms create(ReserveRooms reserveRooms);
    public ReserveRooms findById(Long id);
    public List<ReserveRooms> findAll();
    public ReserveRooms update(ReserveRooms reserveRooms);
    public void delete(ReserveRooms reserveRooms);
}
