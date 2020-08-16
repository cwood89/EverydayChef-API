package com.everydaychef.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocsController {

  @GetMapping("/")
  public String greeting() {
    // put documentation here
    return "index";
  }
}