package com.example.myrecipebook.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
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
}
