package com.example.myrecipebook.init;

import com.example.myrecipebook.service.CategoryService;
import com.example.myrecipebook.service.RoleService;
import com.example.myrecipebook.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {

    private CategoryService categoryService;

    private RoleService roleService;

    private UserService userService;



    public Seeder(CategoryService categoryService, RoleService roleService, UserService userService) {
        this.categoryService = categoryService;
        this.roleService = roleService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {

        this.categoryService.seedCategories();

        this.roleService.seedRoles();

        this.userService.seedAdmin();

    }


}
