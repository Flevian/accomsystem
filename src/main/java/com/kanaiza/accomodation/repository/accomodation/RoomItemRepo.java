package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.User;
import com.kanaiza.accomodation.domain.accomodation.RoomItem;
import com.kanaiza.accomodation.domain.enumeration.RoomItemClearStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomItemRepo extends JpaRepository<RoomItem , Long>{
    public List<RoomItem> findByClearStatusAndStudent(RoomItemClearStatus status , User student);
    public List<RoomItem> findByStudent(User student);
}
