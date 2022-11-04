package com.example.demo.controllers;


import com.example.demo.model.Recipe;
import com.example.demo.services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.BadAttributeValueExpException;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@AllArgsConstructor
public class RecipeController {

    public final RecipeService recipeService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Recipe recipe) {
        try {
            recipeService.create(recipe);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Recipe> getRecipes() {
        return recipeService.getRecipes();
    }


}
