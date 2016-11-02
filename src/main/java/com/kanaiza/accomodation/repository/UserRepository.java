package com.kanaiza.accomodation.repository;

import com.kanaiza.accomodation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    User findByLoginId(String loginId);

    User findByEmail(String email);
}
