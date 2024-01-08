package com.example.myrecipebook.service;

import com.example.myrecipebook.model.dto.AddRecipeDTO;
import com.example.myrecipebook.model.dto.SearchRecipeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface RecipeService {
    void addRecipe(AddRecipeDTO addRecipeDTO, String username);


    Page<SearchRecipeDTO> findByCategory(String categoryName, Pageable pageable);

    Page<SearchRecipeDTO> getSearchedRecipes(Pageable pageable);

    Page<SearchRecipeDTO> findByTitleAndCategory(String title, String category, Pageable pageable);

    Page<SearchRecipeDTO> findByTitle(String title, Pageable pageable);
}
