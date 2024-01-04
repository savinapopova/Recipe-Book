package com.example.myrecipebook.service.impl;

import com.example.myrecipebook.model.dto.AddRecipeDTO;
import com.example.myrecipebook.model.dto.SearchRecipeDTO;
import com.example.myrecipebook.model.entity.Category;
import com.example.myrecipebook.model.entity.Recipe;
import com.example.myrecipebook.model.entity.User;
import com.example.myrecipebook.model.enums.CategoryName;
import com.example.myrecipebook.repository.RecipeRepository;
import com.example.myrecipebook.service.CategoryService;
import com.example.myrecipebook.service.RecipeService;
import com.example.myrecipebook.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

   private RecipeRepository recipeRepository;
    private CategoryService categoryService;

    private UserService userService;

    private ModelMapper modelMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, CategoryService categoryService,
                             UserService userService, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addRecipe(AddRecipeDTO addRecipeDTO , String username) {
        Category category = this.categoryService.findByCategoryName(addRecipeDTO.getCategory());
        User user = this.userService.findByUsername(username);

        Recipe recipe = new Recipe(addRecipeDTO.getTitle(), addRecipeDTO.getIngredients(), addRecipeDTO.getSteps(),
                addRecipeDTO.getImageUrl(), category);
        recipe.setUser(user);
        this.recipeRepository.save(recipe);
    }

    @Override
    public Page<SearchRecipeDTO> findByCategory(String category, Pageable pageable) {

        if (category.toLowerCase().equals("all")) {
            return getSearchedRecipes(pageable);

        }

        return this.recipeRepository.findByCategoryName(CategoryName.valueOf(category.toUpperCase()), pageable)
                .map(recipe -> modelMapper.map(recipe, SearchRecipeDTO.class));
    }

    @Override
    public Page<SearchRecipeDTO> getSearchedRecipes(Pageable pageable) {
        return this.recipeRepository.findAll(pageable)
                .map(recipe -> modelMapper.map(recipe, SearchRecipeDTO.class));
    }
}
