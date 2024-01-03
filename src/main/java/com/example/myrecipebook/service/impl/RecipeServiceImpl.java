package com.example.myrecipebook.service.impl;

import com.example.myrecipebook.model.dto.AddRecipeDTO;
import com.example.myrecipebook.model.entity.Category;
import com.example.myrecipebook.model.entity.Recipe;
import com.example.myrecipebook.repository.RecipeRepository;
import com.example.myrecipebook.service.CategoryService;
import com.example.myrecipebook.service.RecipeService;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

   private RecipeRepository recipeRepository;
    private CategoryService categoryService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, CategoryService categoryService) {
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
    }

    @Override
    public void addRecipe(AddRecipeDTO addRecipeDTO) {
        Category category = this.categoryService.findByCategoryName(addRecipeDTO.getCategory());

        Recipe recipe = new Recipe(addRecipeDTO.getTitle(), addRecipeDTO.getIngredients(), addRecipeDTO.getSteps(),
                addRecipeDTO.getImageUrl(), category);
        this.recipeRepository.save(recipe);
    }
}
