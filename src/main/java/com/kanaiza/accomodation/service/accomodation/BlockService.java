package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Block;
import com.kanaiza.accomodation.domain.accomodation.Room;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by wladek on 9/22/16.
 */
public interface BlockService {
    public Block create(Block block);
    public Block findById(Long id);
    public List<Block> findAll();
    public Block update(Block block);
    public void delete(Block block);
    public Page<Room> findRooms(Long blockId , int page , int size);
}
