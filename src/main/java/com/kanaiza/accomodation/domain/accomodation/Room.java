package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;
import com.kanaiza.accomodation.domain.enumeration.BedStatus;
import com.kanaiza.accomodation.domain.enumeration.RoomStatus;
import com.kanaiza.accomodation.domain.enumeration.RoomType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanaiza on 11/2/16.
 */
@Entity
public class Room extends AbstractModel {
    @NotEmpty(message = "Provide room number")
    private String name;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    @ManyToOne
    private Block block;
    @NotNull(message = "Provide cost of room")
    private Long cost;
    private int capacity;
    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Bed> beds = new ArrayList<>();
    @OneToOne(mappedBy = "room", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private ReserveRooms reservedNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }

    @Transient
    private Long blockId;

    public Long getBlockId() {
        return blockId;
    }

    public void setBlockId(Long blockId) {
        this.blockId = blockId;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String status(List<Bed> bedList , int roomCapacity){
        String status = "";
        int spaceAvailable = 0;

        for (Bed bed : bedList){
            if (bed.getStatus() == BedStatus.AVAILABLE){
                spaceAvailable = spaceAvailable + 1;
            }
        }

        if (spaceAvailable == 0){
            status = "Full";
        }else {
            status = spaceAvailable+" beds available";
        }

        return status;
    }

    public boolean capacityExceeded(){
        return (capacity <= beds.size());
    }

    public ReserveRooms getReservedNo() {
        return reservedNo;
    }

    public void setReservedNo(ReserveRooms reservedNo) {
        this.reservedNo = reservedNo;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
