package com.oblig1.o1.models;

import java.time.Instant;

/**
 * Vote
 */
public class Vote {

  private User caster;
  private VoteOption selected;
  private Instant publishedAt;
  
  public Vote(User caster, VoteOption selected){
    this.caster = caster;
    this.selected = selected;
    publishedAt = java.time.Instant.now();
  }

  public VoteOption getSelected() {
    return selected;
  }

  public void setSelected(VoteOption selected) {
    this.selected = selected;
  }

public User getCaster() {
    return caster;
  }

  public void setCaster(User caster) {
    this.caster = caster;
  }

  public Instant getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(Instant publishedAt) {
    this.publishedAt = publishedAt;
  }
}
