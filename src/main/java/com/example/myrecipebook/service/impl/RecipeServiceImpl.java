package com.example.myrecipebook.service.impl;

import com.example.myrecipebook.exception.ObjectNotFoundException;
import com.example.myrecipebook.model.dto.AddRecipeDTO;
import com.example.myrecipebook.model.dto.EditRecipeDTO;
import com.example.myrecipebook.model.dto.RecipeDTO;
import com.example.myrecipebook.model.dto.SearchRecipeDTO;
import com.example.myrecipebook.model.entity.Category;
import com.example.myrecipebook.model.entity.Recipe;
import com.example.myrecipebook.model.entity.User;
import com.example.myrecipebook.model.enums.CategoryName;
import com.example.myrecipebook.repository.RecipeRepository;
import com.example.myrecipebook.service.CategoryService;
import com.example.myrecipebook.service.RecipeService;
import com.example.myrecipebook.service.UserService;
import org.apache.commons.validator.routines.UrlValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

   private RecipeRepository recipeRepository;
    private CategoryService categoryService;

    private UserService userService;

    private ModelMapper modelMapper;

    private UrlValidator urlValidator;

    public RecipeServiceImpl(RecipeRepository recipeRepository, CategoryService categoryService,
                             UserService userService, ModelMapper modelMapper, UrlValidator urlValidator) {
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.urlValidator = urlValidator;
    }

    @Override
    public void addRecipe(AddRecipeDTO addRecipeDTO , String username) {
        Category category = this.categoryService.findByCategoryName(addRecipeDTO.getCategory());
        User user = this.userService.findByUsername(username);
        String imageUrl = addRecipeDTO.getImageUrl();
        imageUrl = getImageUrl(imageUrl);

        Recipe recipe = new Recipe(addRecipeDTO.getTitle(), addRecipeDTO.getIngredients(), addRecipeDTO.getSteps(),
                imageUrl, category);
        recipe.setUser(user);
        this.recipeRepository.save(recipe);
    }

    private String getImageUrl(String imageUrl) {
        if (imageUrl != null && !this.urlValidator.isValid(imageUrl)) {
            imageUrl = "";
        }
        return imageUrl;
    }

    @Override
    public Page<SearchRecipeDTO> findByCategory(String category, Pageable pageable, String username) {


        if (category.toLowerCase().equals("all")) {
            return getSearchedRecipes(pageable, username);

        }

        categoryService.checkCategoryAvailable(category);
        User user = this.userService.findByUsername(username);

        return this.recipeRepository.findByUserAndCategoryName(user,
                        CategoryName.valueOf(category.toUpperCase()), pageable)
                .map(recipe -> modelMapper.map(recipe, SearchRecipeDTO.class));
    }

    @Override
    public Page<SearchRecipeDTO> getSearchedRecipes(Pageable pageable, String username) {
        User user = this.userService.findByUsername(username);
        return this.recipeRepository.findAllByUser(pageable, user)
                .map(recipe -> modelMapper.map(recipe, SearchRecipeDTO.class));
    }

    @Override
    public Page<SearchRecipeDTO> findByTitleAndCategory(String title, String category, Pageable pageable,
                                                        String username) {
        if ((category ==null || category.toLowerCase().equals("all") ||category.trim().isBlank())
        && (title == null || title.trim().isBlank())) {
            return getSearchedRecipes(pageable, username);
        }

        if (category == null || category.toLowerCase().equals("all") || category.trim().isBlank()) {
            return findByTitle(title, pageable, username);
        }


        if (title == null || title.trim().isBlank()) {
            return findByCategory(category, pageable, username);
        }

        User user = this.userService.findByUsername(username);

        return this.recipeRepository.findAllByUserAndTitleContainingAndCategoryName(user,title, CategoryName.valueOf(category.toUpperCase()), pageable)
                .map(recipe -> modelMapper.map(recipe, SearchRecipeDTO.class));
    }

    @Override
    public Page<SearchRecipeDTO> findByTitle(String title, Pageable pageable, String username) {

        if (title == null || title.trim().isBlank()) {
            return getSearchedRecipes(pageable, username);
        }

        User user = this.userService.findByUsername(username);

        return this.recipeRepository.findByUserAndTitleContaining(user,title, pageable)
                .map(recipe -> modelMapper.map(recipe, SearchRecipeDTO.class));
    }

    @Override
    public RecipeDTO findById(Long id, String username) {
        User user = this.userService.findByUsername(username);
        Recipe recipe = this.recipeRepository.findByUserAndId(user, id)
                .orElseThrow(() -> new ObjectNotFoundException("Recipe not found!"));

        List<String> ingredients = Arrays
                .stream(recipe.getIngredients().split(System.lineSeparator()))
                .collect(Collectors.toList());
        List<String> steps = Arrays
                .stream(recipe.getSteps().split(System.lineSeparator()))
                .collect(Collectors.toList());

        RecipeDTO recipeDTO = modelMapper.map(recipe, RecipeDTO.class);
        recipeDTO.setIngredients(ingredients);
        recipeDTO.setSteps(steps);
        return recipeDTO;
    }

    @Override
    public void deleteRecipe(Long id, String username) {
        User user = this.userService.findByUsername(username);
        Recipe recipe = this.recipeRepository.findByUserAndId(user, id)
                .orElseThrow(() -> new ObjectNotFoundException("Recipe not found!"));

        this.recipeRepository.delete(recipe);
    }

    @Override
    public void editRecipe(Long id, EditRecipeDTO recipeDTO, String username) {

        User user = this.userService.findByUsername(username);
        Recipe recipe = this.recipeRepository.findByUserAndId(user, id)
                .orElseThrow(() -> new ObjectNotFoundException("Recipe not found!"));
        categoryService.checkCategoryAvailable(recipeDTO.getCategoryName().name());

        recipe.setTitle(recipeDTO.getTitle());

        String imageUrl = recipeDTO.getImageUrl();
        imageUrl = getImageUrl(imageUrl);

        recipe.setImageUrl(imageUrl);
        recipe.setCategory(this.categoryService.findByCategoryName(recipeDTO.getCategoryName().name()));
        recipe.setIngredients(recipeDTO.getIngredients());
        recipe.setSteps(recipeDTO.getSteps());

        this.recipeRepository.save(recipe);
    }

    @Override
    public EditRecipeDTO findRecipeToEdit(Long id, String username) {

        User user = this.userService.findByUsername(username);
        Recipe recipe = this.recipeRepository.findByUserAndId(user, id)
                .orElseThrow(() -> new ObjectNotFoundException("Recipe not found!"));

        EditRecipeDTO editRecipeDTO = modelMapper.map(recipe, EditRecipeDTO.class);


        return editRecipeDTO;
    }
}
