package com.everydaychef.main.model;

public class FavoriteRequest {
  private Long userId;
  private String recipeId;

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

  public FavoriteRequest() {
  }

  public FavoriteRequest(Long userId, String recipeId) {
    this.userId = userId;
    this.recipeId = recipeId;
  }

}