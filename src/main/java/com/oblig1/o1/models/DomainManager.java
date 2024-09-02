package com.oblig1.o1.models;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * DomainManager
 */
@Component
public class DomainManager {
  
  private Map<Integer,Poll> Polls;
  private Map<Integer, User> Users;
  private int pollkey;
  private int userskey;
  
  public DomainManager(){
    this.Polls = new HashMap<>();
    this.Users = new HashMap<>();
    this.pollkey = 0;
    this.userskey = 0;
  }

  public Map<Integer, Poll> getPolls() {
    return Polls;
  }

  public boolean addUser(User user){
    if (!Users.containsValue(user)){
      Users.put(userskey, user);
      userskey++;
      return true;
    }
    return false;
  }

  public boolean addPoll(Poll poll){
    if (!Polls.containsValue(poll)){
      Polls.put(pollkey, poll);
      pollkey++;
      return true;
    }
    return false;
  }

  public boolean castVote(Poll poll, Vote vote){
    boolean voted = false;
    if (Polls.containsValue(poll)){
      voted = poll.vote(vote);
    }
    return voted;
  }

  public User removeUser(Integer userKey){
    if (Users.containsKey(userKey)){
      User removed = Users.get(userKey);
      Users.remove(userKey);
      return removed;
    }
    return null;
  }

  public Poll removePoll(Integer pollkey){
    if (Polls.containsKey(pollkey)){
      Poll removed = Polls.get(pollkey);
      Polls.remove(pollkey);
      return removed;
    }
    return null;
  }

  public User getUser(int index){
    return Users.get(index);
  }

  public boolean removeVote(Poll poll, Vote vote){
    return poll.getVotes().removeIf(v -> poll.getVotes().contains(vote));
  }

  public void setPolls(Map<Integer, Poll> polls) {
    Polls = polls;
  }

  public Map<Integer, User> getUsers() {
    return Users;
  }

  public void setUsers(Map<Integer, User> users) {
    Users = users;
  }

  
  
}
