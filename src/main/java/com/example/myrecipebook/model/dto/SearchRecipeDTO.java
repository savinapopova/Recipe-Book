package com.example.myrecipebook.model.dto;

import lombok.Data;


public class SearchRecipeDTO {

    private Long id;

    private String title;

    private String imageUrl;

    public SearchRecipeDTO() {
    }

    public Long getId() {
        return id;
    }

    public SearchRecipeDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SearchRecipeDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public SearchRecipeDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
