package com.example.myrecipebook.model.dto;

import com.example.myrecipebook.model.enums.CategoryName;
import lombok.Data;

import java.util.List;

@Data
public class RecipeDTO {

    private Long id;

    private String title;

    private String imageUrl;

    private CategoryName categoryName;

    private List<String> ingredients;

    private List<String> steps;

    public RecipeDTO() {
    }
}
