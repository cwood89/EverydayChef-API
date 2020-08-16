package com.everydaychef.main.controller;

import com.everydaychef.main.model.ApiRecipe;
import com.everydaychef.main.model.Recipe;

import com.everydaychef.main.service.RecipeService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RecipeController {

  @Autowired
  private RecipeService apiService;

  @GetMapping("/")
  public String greeting() {
    // put documentation here
    return "Hello World";
  }

  @GetMapping("/recipes")
  public List<ApiRecipe> recipes(@RequestParam(value = "q", required = true) String search) {

    return apiService.getRecipes(search);
    // // hit our WINdb for recipes
    // // send all of it
  }

  @PostMapping("/recipes")
  public Recipe saveRecipe(Recipe recipe) {

    return apiService.saveRecipe(recipe);
  }
}