package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;
import com.kanaiza.accomodation.domain.enumeration.ReserveRoomStatus;

import javax.persistence.*;

/**
 * Created by kanaiza on 10/30/16.
 */
@Entity
public class ReserveRooms extends AbstractModel{
    @Enumerated(EnumType.STRING)
    private ReserveRoomStatus reserveRoomStatus;

    @OneToOne
    private Room room;

    public ReserveRoomStatus getReserveRoomStatus() {
        return reserveRoomStatus;
    }

    public void setReserveRoomStatus(ReserveRoomStatus reserveRoomStatus) {
        this.reserveRoomStatus = reserveRoomStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    @Transient
    private String reserveId;

    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }
    @Transient
    private Long blockId;

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    @Transient
    private Long roomId;
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }



}
