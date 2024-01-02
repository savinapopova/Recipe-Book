package com.example.myrecipebook.web;

import com.example.myrecipebook.model.dto.RegisterUserDTO;
import com.example.myrecipebook.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute
    public RegisterUserDTO init () {
        return new RegisterUserDTO();
    }

    @GetMapping("/users/register")
    public String register () {
        return "register";
    }

    @PostMapping("/users/register")
    public String register (@Valid RegisterUserDTO registerUserDTO, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerUserDTO", registerUserDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerUserDTO", bindingResult);
            return "redirect:/users/register";
        }

        this.userService.register(registerUserDTO);
        return "redirect:/";
    }
}
