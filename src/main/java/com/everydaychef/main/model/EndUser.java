package com.everydaychef.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  private List<String> favorites; // array of strings containing recipe ids.

  public EndUser() {
  }

  public EndUser(Long id, String firstName, String lastName, String userName, String email, String password,
      String[] favorites) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.favorites = new ArrayList<String>();
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

  public List<String> getFavorites() {
    return favorites;
  }

  public void setFavorites(List<String> favorites) {
    this.favorites = favorites;
  }

  public boolean addFavorite(String favorite) {
    return this.favorites.add(favorite);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}