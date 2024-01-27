package com.example.myrecipebook.model.dto;

import com.example.myrecipebook.model.enums.CategoryName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


public class EditRecipeDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String title;


    private String imageUrl;

    @NotNull
    private CategoryName categoryName;

    @NotBlank
    private String ingredients;

    @NotBlank
    private String steps;

    public EditRecipeDTO() {
    }

    public Long getId() {
        return id;
    }

    public EditRecipeDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public EditRecipeDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public EditRecipeDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public EditRecipeDTO setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getIngredients() {
        return ingredients;
    }

    public EditRecipeDTO setIngredients(String ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getSteps() {
        return steps;
    }

    public EditRecipeDTO setSteps(String steps) {
        this.steps = steps;
        return this;
    }
}
