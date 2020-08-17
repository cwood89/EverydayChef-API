package com.everydaychef.main.service;

import java.util.Arrays;
import java.util.List;

import com.everydaychef.main.model.ApiRecipe;
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

  public List<ApiRecipe> getRecipes(String search) {

    String query = recipeUrl + "app_id=" + apiId + "&app_key=" + apiKey + "&to=50&q=" + search;
    RestTemplate restTemplate = new RestTemplate();
    RecipeResponse recipes = restTemplate.getForObject(query, RecipeResponse.class);
    List<ApiRecipe> hits = Arrays.asList(recipes.getHits());
    for (ApiRecipe recipe : hits) {
      recipe.recipe.setRecipeId(recipe.recipe.parseId(recipe.recipe.getUri()));
    }

    return hits;
  }

  public Recipe saveRecipe(Recipe newRecipe) {
    return recipeRepository.save(newRecipe);
  }
}