package com.oblig1.o1.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oblig1.o1.models.DomainManager;
import com.oblig1.o1.models.Message;
import com.oblig1.o1.models.User;

/**
 * UserController
 */
@RestController
@RequestMapping("/api/v2")
public class UserController {

  @Autowired private DomainManager manager;
  
  @GetMapping("/users")
  public ResponseEntity<Object> getAllUsers(){
    Map<Integer, User> users = manager.getUsers();
    if (users.size() == 0){
      return new ResponseEntity<Object>("No users found", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<Object> getUserById(@PathVariable("id") int id){
    User user = manager.getUser(id);
    if (user == null){
      return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  
  @PostMapping("/users")
  public ResponseEntity<Object> addUser(@RequestBody User user){
    if (manager.getUsers().containsValue(user)){
      Message message = new Message("Already used!");
      return new ResponseEntity<>(message, HttpStatus.IM_USED);
    }
    if (user.getVotes() == null){
      user.setVotes(new ArrayList<>());
    }
    if (user.getCreatedPolls() == null){
      user.setCreatedPolls(new ArrayList<>());
    }
    user.getCreatedPolls().stream()
      .filter(p -> !manager.getPolls().containsValue(p))
      .forEach(p -> manager.addPoll(p));
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
           .path("/{id}")
           .buildAndExpand(manager.getpollkey())
           .toUri();
    if (!manager.addUser(user)){
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.created(location).body(user);
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<Object> updateUserById(@PathVariable("id") int id, @RequestBody User user){
    if (user.getUsername() == null || user.getEmail() == null){
      Message message = new Message("Bad request");
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    User updated = manager.getUser(id);
    if (updated == null){
      Message message = new Message("User not found");
      return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    updated.setUsername(user.getUsername());
    updated.setEmail(user.getEmail());
    
    if (user.getVotes() != null){
      updated.setVotes(user.getVotes());
    } else {
      updated.setVotes(new ArrayList<>());
    }
    if (user.getCreatedPolls() != null){
      updated.setCreatedPolls(user.getCreatedPolls());
    } else {
      updated.setCreatedPolls(new ArrayList<>());
    }
    return new ResponseEntity<>(updated, HttpStatus.OK);
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<Object> deleteUserById(@PathVariable("id") int id){
    User deleted = manager.removeUser(id);
    if (deleted == null){
      Message melding = new Message("User with id: " + id + " can not be found");
      return new ResponseEntity<>(melding, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(deleted, HttpStatus.OK);
  }

  
  
}
