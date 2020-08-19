package com.everydaychef.main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonIgnore
  private String uri;

  private String recipeId;
  private String label;
  private String image;
  private String source;
  private String url;
  private Double yield;
  private Double totalTime;
  private String[] ingredientLines;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinTable(name = "recipe_favorites", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "favorite_id"))
  private Set<Favorite> favorites = new HashSet<Favorite>();

  public Recipe(String recipeId, String uri, String label, String image, String source, String url, Double yield,
      Double totalTime, String[] ingredientLines, Set<Favorite> favorites) {
    this.recipeId = recipeId;
    this.uri = uri;
    this.label = label;
    this.image = image;
    this.url = url;
    this.source = source;
    this.yield = yield;
    this.totalTime = totalTime;
    this.ingredientLines = ingredientLines;
    this.favorites = favorites;
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

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public void addFavorite(Favorite favorite) {
    this.favorites.add(favorite);
    favorite.setRecipe(this);
  }

  public void removeFavorite(Favorite favorite) {
    this.favorites.remove(favorite);
    favorite.setRecipe(null);
  }

}