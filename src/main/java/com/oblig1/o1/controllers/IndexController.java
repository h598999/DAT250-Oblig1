package com.oblig1.o1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 */
@RequestMapping("/")
@RestController
public class IndexController {
  
  @GetMapping
  public String getIndex(){
    return "Hello World!;)";
  }
  
}
