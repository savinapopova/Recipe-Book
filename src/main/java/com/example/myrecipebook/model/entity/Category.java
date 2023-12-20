package com.example.myrecipebook.model.entity;

import com.example.myrecipebook.model.enums.CategoryName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
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
}
