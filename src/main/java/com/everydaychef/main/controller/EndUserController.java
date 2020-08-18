package com.everydaychef.main.controller;

import com.everydaychef.main.model.EndUser;
import com.everydaychef.main.model.FavoriteRequest;
import com.everydaychef.main.model.Response;
import com.everydaychef.main.service.EndUserService;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EndUserController {
  @Autowired
  private EndUserService apiService;

  @PostMapping("/signup")
  public Response signup(@RequestBody EndUser endUser, BindingResult bindingResult) {
    return apiService.signup(endUser, bindingResult);
  }

  @PostMapping("/login")
  public Response login(@RequestBody EndUser endUser) {
    return apiService.login(endUser);
  }

  @GetMapping("/logout")
  public Response logout() {
    return apiService.logout();
  }

  @PostMapping("/favorites")
  public Response saveFavorite(@RequestBody FavoriteRequest favorite) {
    return apiService.saveFavorite(favorite);
  }

}