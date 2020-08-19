package com.everydaychef.main.model;

public class FavoriteDTO {
  private Recipe recipe;

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public FavoriteDTO(Recipe recipe) {
    this.recipe = recipe;
  }

  public FavoriteDTO() {
  }
}