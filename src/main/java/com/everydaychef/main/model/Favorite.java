package com.everydaychef.main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany(mappedBy = "userFavorites", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private Set<EndUser> user = new HashSet<EndUser>();

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinTable(name = "recipe_favorites", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "favorite_id"))
  public Recipe recipe;

  public Favorite(Set<EndUser> user, Recipe recipe) {
    this.user = user;
    this.recipe = recipe;
  }

  public Favorite() {
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public Set<EndUser> getUsers() {
    return user;
  }

  public void setUser(Set<EndUser> user) {
    this.user = user;
  }

  public void addUser(EndUser user) {
    this.user.add(user);
    user.getFavorites().add(this);
  }

  public void removeUser(EndUser user) {
    this.user.remove(user);
    user.getFavorites().remove(this);
  }

  @Override
  public String toString() {
    return "Favorite [id=" + id + ", recipe=" + recipe + "]";
  }

}