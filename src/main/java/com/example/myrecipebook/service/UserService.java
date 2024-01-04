package com.example.myrecipebook.service;

import com.example.myrecipebook.model.dto.RegisterUserDTO;
import com.example.myrecipebook.model.entity.User;

public interface UserService {
    void seedAdmin();

    void register(RegisterUserDTO registerUserDTO);

    User findByUsername(String username);
}
