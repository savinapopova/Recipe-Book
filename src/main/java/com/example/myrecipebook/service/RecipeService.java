package com.example.myrecipebook.service;

import com.example.myrecipebook.model.dto.AddRecipeDTO;
import com.example.myrecipebook.model.dto.RecipeDTO;
import com.example.myrecipebook.model.dto.SearchRecipeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface RecipeService {
    void addRecipe(AddRecipeDTO addRecipeDTO, String username);


    Page<SearchRecipeDTO> findByCategory(String categoryName, Pageable pageable, String username);

    Page<SearchRecipeDTO> getSearchedRecipes(Pageable pageable, String username);

    Page<SearchRecipeDTO> findByTitleAndCategory(String title, String category, Pageable pageable, String username);

    Page<SearchRecipeDTO> findByTitle(String title, Pageable pageable, String username);

    RecipeDTO findById(Long id, String username);
}
