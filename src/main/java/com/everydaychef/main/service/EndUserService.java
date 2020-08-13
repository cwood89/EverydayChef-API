package com.everydaychef.main.service;

import javax.validation.Valid;
import com.everydaychef.main.model.EndUser;
import com.everydaychef.main.repository.EndUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class EndUserService {
  @Autowired
  EndUserRepository endUserRepository;

  public EndUser signup(@Valid EndUser endUser, BindingResult bindingResult) {
    // check to see if user exists
    EndUser userExists = endUserRepository.findByUsername(endUser.getUserName());

    if (userExists != null) {
      bindingResult.rejectValue("username", "error.user", "Username is already taken");
    }
    if (!bindingResult.hasErrors()) {
      endUserRepository.save(endUser);
    }
    return endUserRepository.findByUsername(endUser.getUserName());
  }
}