package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {
}
