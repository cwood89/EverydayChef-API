package com.everydaychef.main.model;

import java.util.HashSet;
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
  private Set<EndUser> user = new HashSet<EndUser>();

  public String recipeId;

  public Favorite(Set<EndUser> user, String recipeId) {
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

  public Set<EndUser> getUsers() {
    return user;
  }

  public void setUser(Set<EndUser> user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Favorite [id=" + id + ", recipeId=" + recipeId + ", user=" + user + "]";
  }

}