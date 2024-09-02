package com.oblig1.o1.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Poll
 */
public class Poll {

  private String question;
  private Instant publishedAt;
  private Instant validUntil;

  @JsonBackReference
  private User creator;
  private List<Vote> votes;
  private List<VoteOption> options;

  public Poll(){}

  public Poll(String question, Instant validUntil, User creator){
    this.question = question;
    this.validUntil = validUntil;
    this.publishedAt = java.time.Instant.now();
    this.creator = creator;
    this.votes = new ArrayList<>();
    this.options = new ArrayList<>();
    this.creator.createPoll(this);
  }

  public Poll(String question, Instant validUntil, User creator, List<VoteOption> options){
    this.question = question;
    this.validUntil = validUntil;
    this.publishedAt = java.time.Instant.now();
    this.options = options;
    this.creator = creator;
    this.votes = new ArrayList<>();
    this.creator.createPoll(this);
  }

  public boolean vote(Vote vote){
    if (options.contains(vote.getSelected())){
      vote.getCaster().addVote(vote);
      this.votes.add(vote);
      return true;
    }
    return false;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public Instant getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(Instant publishedAt) {
    this.publishedAt = publishedAt;
  }

  public Instant getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(Instant validUntil) {
    this.validUntil = validUntil;
  }

  public User getCreator() {
    return creator;
  }

  public List<Vote> getVotes() {
    return votes;
  }

  public void setVotes(List<Vote> votes) {
    this.votes = votes;
  }

  public List<VoteOption> getOptions() {
    return options;
  }

  public void setOptions(List<VoteOption> options) {
    this.options = options;
  }

  public String toString(){
    String s = this.question + " " + this.creator.toString();
    return s;
  }
}
