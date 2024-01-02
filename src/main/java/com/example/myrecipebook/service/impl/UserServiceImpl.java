package com.example.myrecipebook.service.impl;

import com.example.myrecipebook.model.dto.RegisterUserDTO;
import com.example.myrecipebook.model.entity.Role;
import com.example.myrecipebook.model.entity.User;
import com.example.myrecipebook.repository.UserRepository;
import com.example.myrecipebook.service.RoleService;
import com.example.myrecipebook.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private RoleService roleService;

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(RoleService roleService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void seedAdmin() {
        if (this.userRepository.count() != 0) {
            return;
        }


        Role userRole = this.roleService.getUserRole();
        Role adminRole = this.roleService.getAdminRole();

        User admin = new User("admin", "admin@email.com",
                this.passwordEncoder.encode("123456"),"Admin",
                "Adminov");
        admin.getRoles().add(userRole);
        admin.getRoles().add(adminRole);
        this.userRepository.save(admin);


    }

    @Override
    public void register(RegisterUserDTO registerUserDTO) {

        Role userRole = this.roleService.getUserRole();

        User user = new User(registerUserDTO.getUsername(),
                registerUserDTO.getEmail(),
                this.passwordEncoder.encode(registerUserDTO.getPassword()),
                registerUserDTO.getFirstName(),
                registerUserDTO.getLastName());
        user.getRoles().add(userRole);
    }

}
