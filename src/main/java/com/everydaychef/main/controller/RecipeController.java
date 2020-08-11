package com.everydaychef.main.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class RecipeController {

  @GetMapping("/")
  public String greeting() {
    return "Hello World";
  }
}