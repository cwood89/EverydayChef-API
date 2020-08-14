package com.everydaychef.main.model;

public class Favorite {
  public Long userId;
  public String recipeId;

  public Favorite(Long userId, String recipeId) {
    this.userId = userId;
    this.recipeId = recipeId;
  }

  public Favorite() {
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(String recipeId) {
    this.recipeId = recipeId;
  }

}