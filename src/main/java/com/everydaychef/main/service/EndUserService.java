package com.everydaychef.main.service;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Optional;

import javax.validation.Valid;
import com.everydaychef.main.model.EndUser;
import com.everydaychef.main.model.EndUserDTO;
import com.everydaychef.main.model.Favorite;
import com.everydaychef.main.model.FavoriteRequest;
import com.everydaychef.main.model.Recipe;
import com.everydaychef.main.model.Response;
import com.everydaychef.main.repository.EndUserRepository;
import com.everydaychef.main.repository.FavoriteRepository;
import com.everydaychef.main.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class EndUserService {

  @Autowired
  EndUserRepository endUserRepository;

  @Autowired
  FavoriteRepository favoriteRepository;

  @Autowired
  RecipeRepository recipeRepository;

  public static boolean emailValidator(String email) {

    // Get an EmailValidator
    EmailValidator validator = EmailValidator.getInstance();

    // Validate specified String containing an email address
    if (!validator.isValid(email)) {
      return false;
    }
    return true;
  }

  public static EndUserDTO createDTO(EndUser user) {
    EndUserDTO userDTO = new EndUserDTO();
    userDTO.setId(user.getId());
    userDTO.setFirstName(user.getFirstName());
    userDTO.setLastName(user.getLastName());
    userDTO.setUserName(user.getUserName());
    userDTO.setEmail(user.getEmail());
    userDTO.setFavorites(user.getFavorites());
    return userDTO;
  }

  public Response signup(@Valid EndUser endUser, BindingResult bindingResult) {
    EndUserDTO userDTO = null;
    // EndUserDTO userDTO = new EndUserDTO();
    // check to see if user exists
    EndUser savedUser = new EndUser();
    EndUser userExists = endUserRepository.findByUserName(endUser.getUserName());
    EndUser emailExists = endUserRepository.findByEmail(endUser.getEmail());
    if (userExists != null) {
      bindingResult.rejectValue("userName", "error.user", "Username is already taken");
      return new Response("error", "Username is already taken.", null);
    }

    if (endUser.getFirstName() == null) {
      return new Response("error", "Please enter your first name.", null);
    } else if (endUser.getLastName() == null) {
      return new Response("error", "Please enter your last name.", null);
    } else if (emailExists != null) {
      return new Response("error", "Theres already an account with that email.", null);
    } else if (endUser.getEmail() == null) {
      return new Response("error", "Please enter an email.", null);
    } else if (!emailValidator(endUser.getEmail())) {
      return new Response("error", "Please enter a valid email.", null);
    } else if (endUser.getPassword() == null) {
      return new Response("error", "Please enter a password.", null);
    } else if (endUser.getUserName() == null) {
      return new Response("error", "Please enter a username.", null);
    }

    if (!bindingResult.hasErrors()) {
      savedUser = endUserRepository.save(endUser);
      userDTO = createDTO(savedUser);
      // userDTO.setId(savedUser.getId());
      // userDTO.setFirstName(savedUser.getFirstName());
      // userDTO.setLastName(savedUser.getLastName());
      // userDTO.setUserName(savedUser.getUserName());
      // userDTO.setEmail(savedUser.getEmail());
      // userDTO.setFavorites(savedUser.getFavorites());

    }

    if (bindingResult.hasErrors()) {
      return new Response("error", "Server error.", null);
    }

    return new Response("success", "Your account has been created.", userDTO);
  }

  public Response login(EndUser endUser) {

    EndUserDTO userDTO = null;

    if (endUser.getUserName() != null) {
      EndUser userByName = endUserRepository.findByUserName(endUser.getUserName());
      if (userByName != null) {
        if (userByName.getPassword().equals(endUser.getPassword())) {
          userDTO = createDTO(userByName);
          return new Response("success", "Login successful.", userDTO);
        } else {
          return new Response("error", "Invalid password.", null);
        }
      } else {
        return new Response("error", "Invalid username.", null);
      }

    } else if (endUser.getEmail() != null) {
      EndUser userByEmail = endUserRepository.findByEmail(endUser.getEmail());
      if (userByEmail != null) {
        if (userByEmail.getPassword().equals(endUser.getPassword())) {
          userDTO = createDTO(userByEmail);
          return new Response("success", "Login successful.", userDTO);
        } else {
          return new Response("error", "Invalid password.", null);
        }
      } else {
        return new Response("error", "Invalid email.", null);
      }

    } else {
      return new Response("error", "Please enter a username or email.", null);
    }

  }

  public Response logout() {
    return new Response("success", "Logged out.", null);
  }

  public Response saveFavorite(FavoriteRequest favoriteRequest) {

    Optional<EndUser> findUser = endUserRepository.findById(favoriteRequest.getUserId());

    if (findUser.isPresent()) {
      EndUser user = findUser.get();
      Favorite favorite = new Favorite();
      Recipe recipe = recipeRepository.save(favoriteRequest.getRecipe());
      favorite.setRecipe(recipe);
      user.addFavorite(favorite);
      favoriteRepository.save(favorite);
      return new Response("success", "Favorite saved.", null);
    } else {
      return new Response("error", "no user present.", null);
    }

  }

  // public String[] getFavorites(Long userId) {
  // Optional<EndUser> endUser = endUserRepository.findById(userId);
  // if (endUser.isPresent()) {
  // EndUser user = endUser.get();
  // return user.getFavoriteIds();
  // // for each id call recipe search function
  // // that returns the recipe obj
  // // create an array of those objects and return that
  // }
  // return null;
  // }

  // public Response removeFavorite(FavoriteRequest favoriteRequest) {

  // Optional<EndUser> findUser =
  // endUserRepository.findById(favoriteRequest.getUserId());

  // if (findUser.isPresent()) {
  // EndUser user = findUser.get();
  // for (Favorite fave : user.getFavorites()) {

  // if (fave.getRecipeId().equals(favoriteRequest.getRecipeId())) {
  // System.out.println(fave);
  // fave.getUsers().clear();
  // user.removeFavorite(fave);
  // }
  // }
  // endUserRepository.save(user);
  // return new Response("success", "Favorite removed.", user);
  // }
  // return new Response("error", "Invalid input", null);
  // }
}