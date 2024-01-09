package com.example.myrecipebook.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


public class AddRecipeDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String ingredients;

    @NotBlank
    private String steps;

    private String imageUrl;

    @NotBlank
    private String category;

    public AddRecipeDTO() {
    }

    public String getTitle() {
        return title;
    }

    public AddRecipeDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIngredients() {
        return ingredients;
    }

    public AddRecipeDTO setIngredients(String ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getSteps() {
        return steps;
    }

    public AddRecipeDTO setSteps(String steps) {
        this.steps = steps;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddRecipeDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public AddRecipeDTO setCategory(String category) {
        this.category = category;
        return this;
    }
}
