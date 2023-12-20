package com.example.myrecipebook.service.impl;

import com.example.myrecipebook.model.entity.Role;
import com.example.myrecipebook.model.enums.RoleName;
import com.example.myrecipebook.repository.RoleRepository;
import com.example.myrecipebook.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seedRoles() {

        if (this.roleRepository.count() == 0) {
            List<Role> roles = Arrays.stream(RoleName.values())
                    .map(Role::new)
                    .collect(Collectors.toList());
            this.roleRepository.saveAll(roles);
        }
    }

    @Override
    public Role getUserRole() {
        return this.roleRepository.findByName(RoleName.USER);
    }

    @Override
    public Role getAdminRole() {
        return this.roleRepository.findByName(RoleName.ADMIN);
    }
}
