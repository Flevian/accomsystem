package com.kanaiza.accomodation.repository;

import com.kanaiza.accomodation.domain.accomodation.NonResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface NonResidentRepo extends JpaRepository<NonResident , Long> {
}
