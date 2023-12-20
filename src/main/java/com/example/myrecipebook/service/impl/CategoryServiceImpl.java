package com.example.myrecipebook.service.impl;

import com.example.myrecipebook.model.entity.Category;
import com.example.myrecipebook.model.enums.CategoryName;
import com.example.myrecipebook.repository.CategoryRepository;
import com.example.myrecipebook.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() {

        if (this.categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(CategoryName.values())
                    .map(Category::new)
                    .collect(Collectors.toList());
            this.categoryRepository.saveAll(categories);
        }

    }
}
