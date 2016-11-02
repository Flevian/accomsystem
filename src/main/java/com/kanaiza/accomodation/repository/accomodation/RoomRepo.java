package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Block;
import com.kanaiza.accomodation.domain.accomodation.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepo extends JpaRepository<Room , Long> {
    Page<Room> findByBlock(Block block , Pageable pageable);
}
