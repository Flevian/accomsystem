package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.accomodation.AccomodationFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kanaiza on 11/2/16.
 */
@Repository
public interface AccomodationFeeRepo extends JpaRepository<AccomodationFee, Long> {
}
