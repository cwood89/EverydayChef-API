package com.everydaychef.main.service;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Optional;

import javax.validation.Valid;
import com.everydaychef.main.model.EndUser;
import com.everydaychef.main.model.Favorite;
import com.everydaychef.main.model.FavoriteRequest;
import com.everydaychef.main.model.Response;
import com.everydaychef.main.repository.EndUserRepository;
import com.everydaychef.main.repository.FavoriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class EndUserService {

  @Autowired
  EndUserRepository endUserRepository;

  @Autowired
  FavoriteRepository favoriteRepository;

  public static boolean emailValidator(String email) {

    // Get an EmailValidator
    EmailValidator validator = EmailValidator.getInstance();

    // Validate specified String containing an email address
    if (!validator.isValid(email)) {
      return false;
    }
    return true;
  }

  public Response signup(@Valid EndUser endUser, BindingResult bindingResult) {
    // check to see if user exists
    EndUser savedUser = new EndUser();
    EndUser userExists = endUserRepository.findByUserName(endUser.getUserName());

    if (userExists != null) {
      bindingResult.rejectValue("userName", "error.user", "Username is already taken");
      return new Response("error", "Username is already taken.", null);
    }

    if (endUser.getFirstName() == null) {
      return new Response("error", "Please enter your first name.", null);
    } else if (endUser.getLastName() == null) {
      return new Response("error", "Please enter your last name.", null);
    } else if (endUser.getEmail() == null) {
      return new Response("error", "Please enter an email.", null);
    } else if (!emailValidator(endUser.getEmail())) {
      return new Response("error", "Please enter a valid email.", null);
    } else if (endUser.getPassword() == null) {
      return new Response("error", "Please enter a password.", null);
    }

    if (!bindingResult.hasErrors()) {
      savedUser = endUserRepository.save(endUser);
    }

    if (bindingResult.hasErrors()) {
      return new Response("error", "Server error.", null);
    }

    return new Response("success", "Your account has been created.", savedUser.getId());
  }

  public Response login(EndUser endUser) {

    if (endUser.getUserName() != null) {
      EndUser userByName = endUserRepository.findByUserName(endUser.getUserName());
      if (userByName != null) {
        if (userByName.getPassword().equals(endUser.getPassword())) {
          return new Response("success", "Login successful.", userByName.getId());
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
          return new Response("success", "Login successful.", userByEmail.getId());
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
      favorite.setRecipeId(favoriteRequest.getRecipeId());
      user.addFavorite(favorite);
      favoriteRepository.save(favorite);
      return new Response("success", "Favorite saved.", user.getId());
    } else {
      return new Response("error", "no user present.", null);
    }

  }

  public String[] getFavorites(Long userId) {
    Optional<EndUser> endUser = endUserRepository.findById(userId);
    if (endUser.isPresent()) {
      EndUser user = endUser.get();
      return user.getFavoriteIds();
    }
    return null;
  }

  public Response removeFavorite(FavoriteRequest favoriteRequest) {

    Optional<EndUser> findUser = endUserRepository.findById(favoriteRequest.getUserId());

    if (findUser.isPresent()) {
      EndUser user = findUser.get();
      for (Favorite fave : user.getFavorites()) {
        if (fave.getRecipeId().equals(favoriteRequest.getRecipeId())) {
          user.removeFavorite(fave);
        }
      }
      return new Response("success", "Favorite removed.", user.getId());
    }
    return new Response("error", "Invalid input", null);
  }
}