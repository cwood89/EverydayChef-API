package com.everydaychef.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public String publisher;
  public String title;
  public String[] ingredients;
  public String source_url;
  public String recipe_id;
  public String image_url;
  public double social_rank;
  public String publisher_url;

  public Recipe(String publisher, String title, String source_url, String recipe_id, String image_url,
      double social_rank, String publisher_url) {
    this.publisher = publisher;
    this.title = title;
    this.source_url = source_url;
    this.recipe_id = recipe_id;
    this.image_url = image_url;
    this.social_rank = social_rank;
    this.publisher_url = publisher_url;
  }

  public Recipe() {
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSource_url() {
    return source_url;
  }

  public void setSource_url(String source_url) {
    this.source_url = source_url;
  }

  public String getRecipe_id() {
    return recipe_id;
  }

  public void setRecipe_id(String recipe_id) {
    this.recipe_id = recipe_id;
  }

  public String getImage_url() {
    return image_url;
  }

  public void setImage_url(String image_url) {
    this.image_url = image_url;
  }

  public double getSocial_rank() {
    return social_rank;
  }

  public void setSocial_rank(double social_rank) {
    this.social_rank = social_rank;
  }

  public String getPublisher_url() {
    return publisher_url;
  }

  public void setPublisher_url(String publisher_url) {
    this.publisher_url = publisher_url;
  }

  public String[] getIngredients() {
    return ingredients;
  }

  public void setIngredients(String[] ingredients) {
    this.ingredients = ingredients;
  }

}