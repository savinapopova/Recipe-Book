package com.example.myrecipebook.model.dto;

import lombok.Data;

@Data
public class SearchRecipeDTO {

    private Long id;

    private String title;

    private String imageUrl;

    public SearchRecipeDTO() {
    }
}
