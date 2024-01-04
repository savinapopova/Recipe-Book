package com.example.myrecipebook.repository;

import com.example.myrecipebook.model.entity.Recipe;
import com.example.myrecipebook.model.enums.CategoryName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Page<Recipe> findByCategoryName(CategoryName categoryName, Pageable pageable);
}
