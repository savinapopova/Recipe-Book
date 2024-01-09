package com.example.myrecipebook.model.dto;

import com.example.myrecipebook.model.enums.CategoryName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;


public class RecipeDTO {

    private Long id;


    private String title;

    private String imageUrl;


    private CategoryName categoryName;


    private List<String> ingredients;


    private List<String> steps;

    public RecipeDTO() {
    }

    public Long getId() {
        return id;
    }

    public RecipeDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public RecipeDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RecipeDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public RecipeDTO setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public RecipeDTO setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public List<String> getSteps() {
        return steps;
    }

    public RecipeDTO setSteps(List<String> steps) {
        this.steps = steps;
        return this;
    }
}
