package com.everydaychef.main.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class EndUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Please provide your first name")
  private String firstName;

  @NotNull(message = "Please provide your last name")
  private String lastName;

  @NotNull(message = "Please provide a username")
  @Length(min = 3, message = "Your username must have at least 3 characters")
  @Length(max = 15, message = "Your username cannot have more than 15 characters")
  @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
  private String userName;

  @NotNull(message = "Please provide an email")
  @Email(message = "Please provide a valid email")
  private String email;

  @NotNull(message = "Please provide a password")
  private String password;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinTable(name = "user_favorites", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "favorite_id"))
  private Set<Favorite> userFavorites = new HashSet<Favorite>();

  public EndUser() {
  }

  public EndUser(Long id, String firstName, String lastName, String userName, String email, String password) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.password = password;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String[] getFavorites() {

    List<String> list = new ArrayList<String>();

    String[] arr = new String[this.userFavorites.size()];

    for (Favorite fave : this.userFavorites) {
      System.out.println(fave.getRecipeId());
      list.add(fave.getRecipeId());
    }
    arr = list.toArray(arr);

    return arr;
  }

  public void addFavorite(Favorite favorite) {
    this.userFavorites.add(favorite);
    favorite.getUsers().add(this);
  }

  public void removeFavorite(Favorite favorite) {
    this.userFavorites.remove(favorite);
    favorite.getUsers().remove(this);
  }

  @Override
  public String toString() {
    return "EndUser [email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName
        + ", userFavorites=" + userFavorites.stream().map(Favorite::getRecipeId).collect(Collectors.toList())
        + ", userName=" + userName + "]";
  }

}