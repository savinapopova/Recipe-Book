package com.example.myrecipebook.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Table(name = "recipes")
@Data
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


    @Column(name = "image_url")
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
}
