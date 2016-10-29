package com.kanaiza.accomodation.repository;

import com.kanaiza.accomodation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wladek
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    User findByLoginId(String loginId);

    User findByEmail(String email);
}
