package com.oblig1.o1.controllers;

import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;

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
import com.oblig1.o1.models.Poll;

/**
 * pollApiController
 */
@RestController
@RequestMapping("/api/v2")
public class PollController{

  @Autowired private DomainManager manager;

  @GetMapping("/init")
  public String initalize(){
    manager.init();
    return "Initialized";
  }

  @GetMapping("/")
  public ResponseEntity<Object> getIndexApi(){
    String message = "Hello index";
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

  @GetMapping("/polls")
  public ResponseEntity<Object> getPolls(){
    if (manager.getPolls().isEmpty()){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(manager.getPolls(), HttpStatus.OK);
  }
  
  @GetMapping("/polls/{id}")
  public ResponseEntity<Object> getPollById(@PathVariable("id") int id){
    if (manager.getPolls().isEmpty()){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(manager.getPolls().get(id), HttpStatus.OK);
  }

  @PostMapping("/polls")
  public ResponseEntity<Object> createPoll(@RequestBody Poll poll) {
    if (manager.getPolls().containsValue(poll)) {
      String message = "Poll with the same question already exists.";
      return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }
    Poll created = new Poll(poll.getQuestion(), poll.getValidUntil(), poll.getCreator());
    int id = manager.getpollkey();
    manager.addPoll(created);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
           .path("/{id}")
           .buildAndExpand(id)
           .toUri();
    System.out.println(manager.getPolls().toString());
    return ResponseEntity.created(location).body(created);
  }

  @PutMapping("/polls/{id}")
  public ResponseEntity<Object> updatePoll(@PathVariable("id") int id, @RequestBody Poll poll){
    Poll deleted = manager.removePoll(id);
    poll.setPublishedAt(Instant.now());
    if (poll.getVotes() == null){
      poll.setVotes(new ArrayList<>());
    }
    if (poll.getOptions() == null){
      poll.setOptions(new ArrayList<>());
    }
    if (deleted == null){
      String message = "Poll with the id doesnt exist and can therefore not be put";
      return ResponseEntity.badRequest().body(message);
    }
    manager.getPolls().put(id, poll);
    return ResponseEntity.ok().body(poll);
  }

  @DeleteMapping("/polls/{id}")
  public ResponseEntity<Object> deletePoll(@PathVariable("id") int id){
    Poll deleted = manager.removePoll(id);
    if (deleted == null){
      String message = "Poll with the id doesnt exist and can therefore not be put";
      return ResponseEntity.badRequest().body(message);
    }
    return ResponseEntity.ok().body(deleted);
  }
}
