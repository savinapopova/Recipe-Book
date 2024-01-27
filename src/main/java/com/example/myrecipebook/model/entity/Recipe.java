package com.example.myrecipebook.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;


    @Column(length = Integer.MAX_VALUE, nullable = false)
    private String ingredients;

    @Column(length = Integer.MAX_VALUE, nullable = false)
    private String steps;


    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

   @ManyToOne
   private Category category;

    @ManyToOne
   private User user;



    public Recipe() {

    }

    public Recipe(String title, String ingredients, String steps, String imageUrl, Category category) {
        this.title = title;
        this.ingredients = ingredients;
        this.steps = steps;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public Recipe setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Recipe setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIngredients() {
        return ingredients;
    }

    public Recipe setIngredients(String ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getSteps() {
        return steps;
    }

    public Recipe setSteps(String steps) {
        this.steps = steps;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Recipe setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Recipe setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Recipe setUser(User user) {
        this.user = user;
        return this;
    }
}
