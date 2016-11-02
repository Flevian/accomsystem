package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.Role;

import java.util.List;



public interface RoleService {
    public Role create(Role role);
    public Role getOne(Long roleId);
    public void delete(Long roleId);
    public List<Role> findAll();
}
