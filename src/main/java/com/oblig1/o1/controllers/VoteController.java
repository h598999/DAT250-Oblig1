package com.oblig1.o1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oblig1.o1.models.Vote;

/**
 * VoteController
 */
@RestController
@RequestMapping("/api/v2")
public class VoteController {
  
  @GetMapping("/votes")
  public ResponseEntity<Object> getAllVotes(){
    //TODO - return all Votes
    return null;
  }

  @GetMapping("/votes/{id}")
  public ResponseEntity<Object> getAllVotesInPoll(@PathVariable("id") int id){
    //TODO - return all the votes in the poll with the given id
    return null;
  }

  @GetMapping("/votes/{username}")
  public ResponseEntity<Object> getAllVotesByUser(@PathVariable("username") String username){
    //TODO - return all the votes done by a user
    return null;
  }

  @PostMapping("/votes/{id}")
  public ResponseEntity<Object> addVoteToPoll(@PathVariable("id") int id, @RequestBody Vote vote){
    //TODO - add the vote to the poll with given id
    return null;
  }

  @PutMapping("/votes/{id}")
  public ResponseEntity<Object> updateVote(@PathVariable int id, @RequestBody Vote vote){
    //TODO - update the vote with given id to the vote given as body
    return null;
  }
  
}
