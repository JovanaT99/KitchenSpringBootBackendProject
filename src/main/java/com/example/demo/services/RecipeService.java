package com.example.demo.services;

import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class RecipeService {
    public final RecipeRepository repository;

    public void create(Recipe recipe) {

        repository.save(recipe);

    }

    public List<Recipe> getRecipes() {
        return repository.findAll();
    }


}
