package com.oblig1.o1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User
 */
public class User {
  private String username;
  private String email;
  private List<Vote> votes;

  @JsonIgnore
  private List<Poll> createdPolls;
  
  public User(String username, String email){
    this.username = username;
    this.email = email;
    this.votes = new ArrayList<>();
    this.createdPolls = new ArrayList<Poll>();
  }


  public void addVote(Vote vote){
    this.votes.add(vote);
  }
  public void createPoll(Poll poll){
    this.createdPolls.add(poll);
  }

  public List<Poll> getCreatedPolls(){
    return this.createdPolls;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Vote> getVotes() {
    return votes;
  }

  public void setVotes(List<Vote> votes) {
    this.votes = votes;
  }

  public void setCreatedPolls(List<Poll> createdPolls) {
    this.createdPolls = createdPolls;
  }

  public String toString(){
    return this.username + " " + this.getEmail();
  }

  @Override
  public boolean equals(Object obj){
    if (this == obj){
      return true;
    }
    if (obj == null | getClass() != obj.getClass()){
      return false;
    }
    User user = (User)obj;
    return Objects.equals(this.username, user.username) && Objects.equals(this.email, user.email);
  }
}
