package com.everydaychef.main.service;

import org.apache.commons.validator.routines.EmailValidator;
import javax.validation.Valid;
import com.everydaychef.main.model.EndUser;
import com.everydaychef.main.model.Response;
import com.everydaychef.main.repository.EndUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class EndUserService {
  @Autowired
  EndUserRepository endUserRepository;

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
}