package com.example.myrecipebook.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "images")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "image_url")
    private String imageUrl;

    @ManyToOne
    private Recipe recipe;

    public Image() {
    }
}
