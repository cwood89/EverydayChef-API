package com.everydaychef.main.model;

public class RecipeResponse {
  public int count;
  public Recipe[] recipes;

  public Recipe[] getRecipes() {
    return recipes;
  }
}