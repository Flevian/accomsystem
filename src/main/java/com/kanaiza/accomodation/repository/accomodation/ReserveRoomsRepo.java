package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Block;
import com.kanaiza.accomodation.domain.accomodation.ReserveRooms;
import com.kanaiza.accomodation.domain.accomodation.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

/**
 * Created by kanaiza on 10/30/16.
 */
@Repository
public interface ReserveRoomsRepo extends JpaRepository<ReserveRooms, Long>{
}
