package com.example.myrecipebook.model.entity;

import com.example.myrecipebook.model.enums.CategoryName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private CategoryName name;

    public Category() {
    }

    public Category(CategoryName name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }
}
