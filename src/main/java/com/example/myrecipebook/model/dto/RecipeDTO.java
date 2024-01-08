package com.example.myrecipebook.model.dto;

import com.example.myrecipebook.model.enums.CategoryName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RecipeDTO {

    private Long id;

    @NotBlank
    private String title;

    private String imageUrl;

    @NotNull
    private CategoryName categoryName;

    @NotNull
    private List<String> ingredients;

    @NotNull
    private List<String> steps;

    public RecipeDTO() {
    }
}
