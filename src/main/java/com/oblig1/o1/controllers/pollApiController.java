package com.oblig1.o1.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oblig1.o1.models.DomainManager;
import com.oblig1.o1.models.Poll;
import com.oblig1.o1.models.User;
import com.oblig1.o1.models.VoteOption;

/**
 * pollApiController
 */
@RestController
@RequestMapping("/api/v2")
public class pollApiController {

  private DomainManager manager = new DomainManager().init();

  @GetMapping("/")
  public ResponseEntity<Object> getIndexApi(){
    User u1 = new User("Jonas", "Jonas@Email.com");;
    Poll poll = new Poll("Hva smaker best?", Instant.MAX, u1, List.of(new VoteOption("Melk", 1), new VoteOption("Vann", 2)));
    return new ResponseEntity<>(poll, HttpStatus.OK);
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


  
}
