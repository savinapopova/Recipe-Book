package com.example.myrecipebook.web;

import com.example.myrecipebook.model.dto.AddRecipeDTO;
import com.example.myrecipebook.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @ModelAttribute
    public AddRecipeDTO init() {
        return new AddRecipeDTO();
    }

    @GetMapping("/recipes/add")
    public String addRecipe() {
        return "add-recipe";
    }

    @PostMapping("/recipes/add")
    public String addRecipe(@Valid AddRecipeDTO addRecipeDTO, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addRecipeDTO", addRecipeDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addRecipeDTO",
                    bindingResult);
            return "redirect:/recipes/add";
        }
        this.recipeService.addRecipe(addRecipeDTO);
        redirectAttributes.addFlashAttribute("sentSuccess", true);
        return "redirect:/recipes/add";
    }
}
