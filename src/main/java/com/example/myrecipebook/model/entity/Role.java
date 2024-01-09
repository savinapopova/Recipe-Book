package com.example.myrecipebook.model.entity;

import com.example.myrecipebook.model.enums.RoleName;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private RoleName name;

    public Role() {
    }

    public Role(RoleName name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public RoleName getName() {
        return name;
    }

    public Role setName(RoleName name) {
        this.name = name;
        return this;
    }
}
