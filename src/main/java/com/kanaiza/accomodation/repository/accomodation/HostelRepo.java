package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by kanaiza on 11/1/16.
 */
@Repository
public interface HostelRepo extends JpaRepository<Hostel , Long> {
}
