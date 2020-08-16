package com.everydaychef.main.model;

public class ApiRecipe {
  public Recipe recipe;

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public ApiRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public ApiRecipe() {
  }

}