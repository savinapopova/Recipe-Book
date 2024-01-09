package com.example.myrecipebook.model.dto;

import com.example.myrecipebook.model.enums.CategoryName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EditRecipeDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String imageUrl;

    @NotNull
    private CategoryName categoryName;

    @NotBlank
    private String ingredients;

    @NotBlank
    private String steps;

    public EditRecipeDTO() {
    }
}
