package com.example.myrecipebook.model.dto;

import com.example.myrecipebook.validation.annotation.PasswordMatch;
import com.example.myrecipebook.validation.annotation.UniqueEmail;
import com.example.myrecipebook.validation.annotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@PasswordMatch(first = "password", second = "confirmPassword")
public class RegisterUserDTO {

    @NotBlank(message = "")
    @Size(min = 3,max = 20,message = "Username must be between 3 and 20 characters")
    @UniqueUsername
    private String username;

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    @UniqueEmail
    private String email;

    @NotBlank(message = "")
    @Size(min = 3,max = 20,message = "Password must be between 3 and 20 characters")
    private String password;

    @NotBlank(message = "")
    @Size(min = 3,max = 20,message = "Confirm password must be between 3 and 20 characters")
    private String confirmPassword;

    @NotBlank(message = "")
    @Size(min = 2,max = 20,message = "First name must be between 2 and 20 characters")
    private String firstName;

    @NotBlank(message = "")
    @Size(min = 2,max = 20,message = "Last name must be between 2 and 20 characters")
    private String lastName;

    public RegisterUserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public RegisterUserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterUserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterUserDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterUserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterUserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
