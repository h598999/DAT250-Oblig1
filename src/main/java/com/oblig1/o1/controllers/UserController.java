package com.oblig1.o1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oblig1.o1.models.User;

/**
 * UserController
 */
@RestController
@RequestMapping("/api/v2")
public class UserController {
  
  @GetMapping("/users")
  public ResponseEntity<Object> getAllUsers(){
    //TODO - return all users
    return null;
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<Object> getUserById(@PathVariable("id") int id){
    //TODO - return the user with the given id
    return null;
  }
  
  @PostMapping("/users")
  public ResponseEntity<Object> getAllUsers(@RequestBody User user){
    //TODO - Add user and return it
    return null;
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<Object> updateUserById(@PathVariable("id") int id, @RequestBody User user){
    //TODO - Update the user witht the given id to the given user
    return null;
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<Object> deleteUserById(@PathVariable("id") int id){
    //TODO - Delete the user with the given id
    return null;
  }

  
  
}
