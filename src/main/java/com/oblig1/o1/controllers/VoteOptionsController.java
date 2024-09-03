package com.oblig1.o1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oblig1.o1.models.VoteOption;

/**
 * VoteOptionsController
 */
@RestController
@RequestMapping("/api/v2")
public class VoteOptionsController {
  
  @GetMapping("/voteoptions")
  public ResponseEntity<Object> getAllVoteOptions(){
    //TODO - return all Vote Options
    return null;
  }

  @GetMapping("/voteoptions/{id}")
  public ResponseEntity<Object> getAllVoteOptionsForPoll(@PathVariable("id") int id){
    //TODO - return all voteoptions for poll with id give
    return null;
  }

  @PostMapping("/voteoptions/{id}")
  public ResponseEntity<Object> addVoteOptionToPoll(@PathVariable("id") int id, @RequestBody VoteOption option){
    //TODO - add voteoption given as requestbody to the poll with the given id
    return null;
  }

  @DeleteMapping("/voteoptions/{id}")
  public ResponseEntity<Object> deleteVoteOptionFromPoll(@PathVariable("id") int id, @RequestBody VoteOption option){
    //TODO - remove the voteoption from the poll with the given id
    return null;
  }
}
