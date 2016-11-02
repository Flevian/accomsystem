package com.kanaiza.accomodation.domain.accomodation;

import com.kanaiza.accomodation.domain.AbstractModel;
import com.kanaiza.accomodation.domain.enumeration.ItemName;
import com.kanaiza.accomodation.domain.enumeration.ItemStatus;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by kanaiza on 11/2/16.
 */
@Entity
public class RoomItemCost extends AbstractModel{

    private static final String NUMBER_FORMAT = "^[0-9]+";

    @Enumerated(EnumType.STRING)
    private ItemName itemName;
    @NotNull(message = "Item cost must be provided")
    @NumberFormat
    private Long unitCost = new Long(50);
    @NotNull(message = "Item cost must be provided")
    @NumberFormat
    private Long totalAvailable = new Long(0);
    private Long totalIssued = new Long(0);

    public ItemName getItemName() {
        return itemName;
    }

    public void setItemName(ItemName itemName) {
        this.itemName = itemName;
    }

    public Long getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Long unitCost) {
        this.unitCost = unitCost;
    }

    public Long getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(Long totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public Long getTotalIssued() {
        return totalIssued;
    }

    public void setTotalIssued(Long totalIssued) {
        this.totalIssued = totalIssued;
    }

    public Long getAvailable(Long total, Long issued){

        return (total - issued);
    }

    @Transient
    @Enumerated(EnumType.ORDINAL)
    private ItemStatus itemStatus;

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }
}
