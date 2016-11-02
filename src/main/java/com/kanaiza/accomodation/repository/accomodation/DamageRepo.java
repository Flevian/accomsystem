package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kanaiza on 10/30/16.
 */
@Repository
public interface DamageRepo extends JpaRepository<Damage, Long> {
}
