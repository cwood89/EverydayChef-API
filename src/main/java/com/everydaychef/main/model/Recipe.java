package com.everydaychef.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String recipeId;
  private String label;
  private String image;
  private String source;
  private String url;
  private Double yield;
  private Double totalTime;
  private String[] ingredientLines;

  public Recipe(String uri, String label, String image, String source, String url, Double yield, Double totalTime,
      String[] ingredientLines) {
    this.recipeId = this.parseId(uri);
    this.label = label;
    this.image = image;
    this.url = url;
    this.source = source;
    this.yield = yield;
    this.totalTime = totalTime;
    this.ingredientLines = ingredientLines;
  }

  public Recipe() {
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Double getYield() {
    return yield;
  }

  public void setYield(Double yield) {
    this.yield = yield;
  }

  public Double getTotalTime() {
    return totalTime;
  }

  public void setTotalTime(Double totalTime) {
    this.totalTime = totalTime;
  }

  public String[] getIngredientLines() {
    return ingredientLines;
  }

  public void setIngredientLines(String[] ingredientLines) {
    this.ingredientLines = ingredientLines;
  }

  public Long getId() {
    return id;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String parseId(String uri) {
    String delimits = "[_]+";
    String[] tokens = uri.split(delimits);
    return tokens[1];
  }

  public String getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(String recipeId) {
    this.recipeId = recipeId;
  }

}