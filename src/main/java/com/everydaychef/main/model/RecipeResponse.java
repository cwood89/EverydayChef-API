package com.everydaychef.main.model;

public class RecipeResponse {
  public String q;
  public ApiRecipe[] hits;

  public String getQ() {
    return q;
  }

  public void setQ(String q) {
    this.q = q;
  }

  public ApiRecipe[] getHits() {
    return hits;
  }

  public void setHits(ApiRecipe[] hits) {
    this.hits = hits;
  }

  public RecipeResponse(String q, ApiRecipe[] hits) {
    this.q = q;
    this.hits = hits;
  }

  public RecipeResponse() {
  }

}