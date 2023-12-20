package com.example.myrecipebook.service;

import com.example.myrecipebook.model.entity.Role;

public interface RoleService {
    void seedRoles();

    Role getUserRole();

    Role getAdminRole();
}
