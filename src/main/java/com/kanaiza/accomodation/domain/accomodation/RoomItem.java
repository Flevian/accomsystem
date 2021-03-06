package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;
import com.kanaiza.accomodation.domain.User;
import com.kanaiza.accomodation.domain.enumeration.ItemCondition;
import com.kanaiza.accomodation.domain.enumeration.ItemName;
import com.kanaiza.accomodation.domain.enumeration.RoomItemClearStatus;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by kanaiza on 11/2/16.
 */
@Entity
public class RoomItem extends AbstractModel {
    private ItemName itemName;
    private ItemCondition itemCondition;
    private Long cost;
    private RoomItemClearStatus clearStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    private User student;

    public ItemName getItemName() {
        return itemName;
    }

    public void setItemName(ItemName itemName) {
        this.itemName = itemName;
    }

    public ItemCondition getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(ItemCondition itemCondition) {
        this.itemCondition = itemCondition;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public RoomItemClearStatus getClearStatus() {
        return clearStatus;
    }

    public void setClearStatus(RoomItemClearStatus clearStatus) {
        this.clearStatus = clearStatus;
    }
}
