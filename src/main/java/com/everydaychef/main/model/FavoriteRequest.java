package com.everydaychef.main.model;

public class FavoriteRequest {

  private Long userId;
  private Recipe recipe;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public FavoriteRequest() {
  }

  public FavoriteRequest(Long userId, Recipe recipe) {

    this.userId = userId;
    this.recipe = recipe;
  }

}