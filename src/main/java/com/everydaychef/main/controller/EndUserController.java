package com.everydaychef.main.controller;

import com.everydaychef.main.model.EndUser;
import com.everydaychef.main.model.Response;
import com.everydaychef.main.service.EndUserService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EndUserController {
  @Autowired
  private EndUserService apiService;

  @PostMapping("/signup")
  public Response signup(@RequestBody EndUser endUser, BindingResult bindingResult) {
    return apiService.signup(endUser, bindingResult);
  }

  @PostMapping("/login")
  public boolean login() {
    return false;
  }

}