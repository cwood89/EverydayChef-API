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

  @Value("${api_url}")
  public String recipeUrl;

  @Value("${api_id}")
  public String apiId;

  @Value("${api_key}")
  public String apiKey;

  public List<Recipe> getRecipes(String search) {

    String query = recipeUrl + "ap_id=" + apiId + "&app_key=" + apiKey + "&q=" + search;
    System.out.println(query);
    RestTemplate restTemplate = new RestTemplate();
    RecipeResponse recipes = restTemplate.getForObject(query, RecipeResponse.class);
    return Arrays.asList(recipes.getRecipes());
  }

  public Recipe saveRecipe(Recipe newRecipe) {
    return recipeRepository.save(newRecipe);
  }
}