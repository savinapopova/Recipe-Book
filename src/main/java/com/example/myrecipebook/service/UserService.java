package com.example.myrecipebook.service;

import com.example.myrecipebook.model.dto.RegisterUserDTO;

public interface UserService {
    void seedAdmin();

    void register(RegisterUserDTO registerUserDTO);
}
