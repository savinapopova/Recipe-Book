package com.example.myrecipebook.service;

import com.example.myrecipebook.model.entity.Category;

public interface CategoryService {
    void seedCategories();

    Category findByCategoryName(String category);
}
