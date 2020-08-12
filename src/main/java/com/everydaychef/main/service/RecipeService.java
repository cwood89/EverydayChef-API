package com.everydaychef.main.service;

import java.util.Arrays;
import java.util.List;

import com.everydaychef.main.model.Recipe;
import com.everydaychef.main.model.RecipeResponse;
import com.everydaychef.main.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecipeService {

  @Autowired
  RecipeRepository recipeRepository;

  @Value("${recipe_url}")
  public String recipeUrl;

  public List<Recipe> getRecipes(String search) {
    RestTemplate restTemplate = new RestTemplate();
    RecipeResponse recipes = restTemplate.getForObject(recipeUrl + search, RecipeResponse.class);
    return Arrays.asList(recipes.getRecipes());
  }

  public Recipe saveRecipe(Recipe newRecipe) {
    return recipeRepository.save(newRecipe);
  }
}