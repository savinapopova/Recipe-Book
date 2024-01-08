package com.example.myrecipebook.repository;

import com.example.myrecipebook.model.dto.SearchRecipeDTO;
import com.example.myrecipebook.model.entity.Recipe;
import com.example.myrecipebook.model.entity.User;
import com.example.myrecipebook.model.enums.CategoryName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Page<Recipe> findByUserAndCategoryName(User user, CategoryName categoryName, Pageable pageable);

    Page<Recipe> findByUserAndTitleContaining(User user, String title, Pageable pageable);

    Page<Recipe> findAllByUserAndTitleContainingAndCategoryName(User user, String title, CategoryName categoryName, Pageable pageable);

    Page<Recipe> findAllByUser(Pageable pageable, User user);

    Optional<Recipe> findByUserAndId(User user, Long id);
}
