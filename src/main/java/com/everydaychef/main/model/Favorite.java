package com.everydaychef.main.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany(mappedBy = "userFavorites")
  private Set<EndUser> user;

  public String recipeId;

  public Favorite(Long id, Set<EndUser> user, String recipeId) {
    this.id = id;
    this.user = user;
    this.recipeId = recipeId;
  }

  public Favorite() {
  }

  public String getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(String recipeId) {
    this.recipeId = recipeId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<EndUser> getUsers() {
    return user;
  }

  public void setUser(Set<EndUser> user) {
    this.user = user;
  }

}