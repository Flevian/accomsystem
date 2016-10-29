package com.kanaiza.accomodation.service;

import com.kanaiza.accomodation.domain.User;

import java.util.List;

/**
 * @author wladek
 */
public interface UserService {

    User addNewUser(User user);

    void login(User user);

    User findById(Long id);

    public List<User> findAll();
}
