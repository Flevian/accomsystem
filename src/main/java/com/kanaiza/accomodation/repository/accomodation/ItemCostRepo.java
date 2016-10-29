package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.accomodation.RoomItemCost;
import com.kanaiza.accomodation.domain.enumeration.ItemName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wladek on 9/28/16.
 */
@Repository
public interface ItemCostRepo extends JpaRepository<RoomItemCost , Long>{
    public RoomItemCost findByItemName(ItemName itemName);
}
