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

    @ElementCollection
    @CollectionTable(name = "ingredients_quantity", joinColumns = @JoinColumn(name = "recipe_id"))
    @MapKeyColumn(name = "ingredient")
    @Column(name = "quantity")
    private Map<String, String> ingredients = new LinkedHashMap<>();

    @Lob
    private String steps;

   @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private List<Image> images = new ArrayList<>();

   @ManyToOne
   private Category category;



    public Recipe() {

    }

    // Добавяне на съставка към рецептата
    public void addIngredient(String ingredientName, String grammage) {
        ingredients.put(ingredientName, grammage);
    }

    // Премахване на съставка от рецептата
    public void removeIngredient(String ingredientName) {
        ingredients.remove(ingredientName);
    }
}
