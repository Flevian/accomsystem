package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Disciplinary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kanaiza on 10/29/16.
 */
@Repository
public interface DisciplinaryRepo extends JpaRepository<Disciplinary, Long> {

}

