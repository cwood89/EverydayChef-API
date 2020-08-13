package com.everydaychef.main.service;

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

  public Response signup(@Valid EndUser endUser, BindingResult bindingResult) {
    // check to see if user exists
    EndUser userExists = endUserRepository.findByUserName(endUser.getUserName());

    if (userExists != null) {
      bindingResult.rejectValue("userName", "error.user", "Username is already taken");
      return new Response("error", "Username is already taken.");
    }

    if (!bindingResult.hasErrors()) {
      endUserRepository.save(endUser);
    }

    if (bindingResult.hasErrors()) {
      return new Response("error", "Server error.");
    }

    return new Response("success", "Your account has been created.");
  }
}