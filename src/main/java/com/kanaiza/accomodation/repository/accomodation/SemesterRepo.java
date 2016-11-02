package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SemesterRepo extends JpaRepository<Semester , Long> {
}
