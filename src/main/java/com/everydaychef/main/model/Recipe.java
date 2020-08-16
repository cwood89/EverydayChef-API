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

  private String label;
  private String image;
  private String url;
  private Double yield;
  private Double totalTime;
  private String[] ingredientLines;

  public Recipe(String label, String image, String url, Double yield, Double totalTime, String[] ingredientLines) {
    this.label = label;
    this.image = image;
    this.url = url;
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

}