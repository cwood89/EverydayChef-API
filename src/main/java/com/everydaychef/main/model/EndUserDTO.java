package com.everydaychef.main.model;

import java.util.HashSet;
import java.util.Set;

public class EndUserDTO {
  private Long id;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;
  private Set<Recipe> favorites;

  public EndUserDTO(Long id, String firstName, String lastName, String userName, String email, Set<Recipe> favorites) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.favorites = favorites;
  }

  public EndUserDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Recipe> getFavorites() {
    return favorites;
  }

  public void setFavorites(Set<Recipe> favorites) {
    this.favorites = favorites;
  }

  public Set<Recipe> getRecipes(Set<Favorite> favorites) {
    Set<Recipe> recipes = new HashSet<Recipe>();
    for (Favorite fave : favorites) {
      recipes.add(fave.getRecipe());
    }
    return recipes;
  }
}