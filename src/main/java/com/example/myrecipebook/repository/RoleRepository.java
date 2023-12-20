package com.example.myrecipebook.repository;

import com.example.myrecipebook.model.entity.Role;
import com.example.myrecipebook.model.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName name);
}
