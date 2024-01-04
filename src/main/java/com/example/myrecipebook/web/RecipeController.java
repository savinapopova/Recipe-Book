package com.example.myrecipebook.web;

import com.example.myrecipebook.model.dto.AddRecipeDTO;
import com.example.myrecipebook.model.dto.SearchRecipeDTO;
import com.example.myrecipebook.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

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
                            RedirectAttributes redirectAttributes, Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addRecipeDTO", addRecipeDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addRecipeDTO",
                    bindingResult);
            return "redirect:/recipes/add";
        }
        this.recipeService.addRecipe(addRecipeDTO, principal.getName());
        redirectAttributes.addFlashAttribute("sentSuccess", true);
        return "redirect:/recipes/add";
    }

    @GetMapping("/recipes")
    public String search() {
        return "redirect:recipes/all";
    }

    @GetMapping("/recipes/{category}")
    public String searchByCategory(@PathVariable String category,
                                   @RequestParam(name = "page", defaultValue = "1") int page,
                                   @RequestParam(name = "size", defaultValue = "5") int size,
                                   Model model) {
        Page<SearchRecipeDTO> recipeDTOPage = this.recipeService
                .findByCategory(category, PageRequest.of(page -1, size));
                prepareModelAttributes(recipeDTOPage, size, model);

        return "all-recipes";
    }

    private void prepareModelAttributes(Page<SearchRecipeDTO> recipeDTOPage, int size, Model model) {
        long totalElements = recipeDTOPage.getTotalElements();

        model.addAttribute("recipes", recipeDTOPage.getContent());
        model.addAttribute("currentPage", recipeDTOPage.getNumber() + 1);
        model.addAttribute("totalPages", recipeDTOPage.getTotalPages());

        int indexOfLastRecipe = (recipeDTOPage.getNumber() + 1) * size;
        int indexOfFirstRecipe = indexOfLastRecipe - size;
        int lastItem = (int) Math.min(totalElements, indexOfLastRecipe);

        model.addAttribute("indexOfFirstRecipe", indexOfFirstRecipe);
        model.addAttribute("indexOfLastRecipe", indexOfLastRecipe);
        model.addAttribute("lastItem", lastItem);
        model.addAttribute("totalElements", totalElements);
    }
}
