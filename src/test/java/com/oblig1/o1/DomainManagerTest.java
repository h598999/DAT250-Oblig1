package com.oblig1.o1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
// import java.util.List;
import java.util.List;

// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.oblig1.o1.models.DomainManager;
import com.oblig1.o1.models.Poll;
import com.oblig1.o1.models.User;
import com.oblig1.o1.models.Vote;
// import com.oblig1.o1.models.Vote;
// import com.oblig1.o1.models.VoteOption;
import com.oblig1.o1.models.VoteOption;

/**
 * DomainManagerTest
 */
public class DomainManagerTest {

  // private DomainManager manager;
  //
  // private Poll p1;
  // private Poll p2;
  //
  // private User u1;
  // private User u2;
  //
  // private VoteOption o1;
  // private VoteOption o2;
  //
  // private Vote v1;
  // private Vote v2;
  
  // @BeforeEach
  // public void setUp(){
  //   this.manager = new DomainManager();
  //
  //   this.o1 = new VoteOption("Melk", 1);
  //   this.o2 = new VoteOption("Vann", 2);
  //
  //   this.u1 = new User("Jonas", "Jonas@email.com");
  //   this.u2 = new User("Katrine", "Katrine@email.com");
  //
  //   this.v1 = new Vote(u1, o1);
  //   this.v2 = new Vote(u2, o2);
  //
  //   this.p1 = new Poll("Hva smaker best?", Instant.MAX, this.u1, List.of(o1,o2));
  //   this.p2 = new Poll("Hva smaker best?", Instant.MAX, this.u2, List.of(o1,o2));
  // }
  // public void cleanUp(){
  //
  // }

  @Test
  public void CreatePollTest(){
    DomainManager manager = new DomainManager();
    User u1 = new User("Jonas", "Jonas@email.com");
    manager.addUser(u1);
    Poll p1 = new Poll("Hva smaker best?", Instant.MAX, manager.getUser(0));
    assertTrue(manager.addPoll(p1));
    assertTrue(manager.getPolls().size() == 1);
    assertTrue(manager.getUser(0).getCreatedPolls().contains(p1));
  }

  @Test
  public void CreateUserTest(){
    DomainManager manager = new DomainManager();
    User u1 = new User("Jonas", "Jonas@email.com");

    assertTrue(manager.addUser(u1));
    assertTrue(manager.getUsers().size() == 1);
    assertTrue(manager.getUser(0).equals(u1));
  }

  @Test
  public void removePollTest(){
    DomainManager manager = new DomainManager();
    User u1 = new User("Jonas", "Jonas@email.com");
    Poll p1 = new Poll("Hva smaker best?", Instant.MAX, u1);

    assertTrue(manager.addUser(u1));
    assertTrue(manager.addPoll(p1));
    assertTrue(manager.getUsers().size() == 1);
    assertTrue(manager.getUser(0).equals(u1));
    assertTrue(manager.getPolls().size() == 1);
    assertTrue(manager.getUser(0).getCreatedPolls().contains(p1));
    assertTrue(manager.removePoll(0).equals(p1));
  }

  @Test
  public void castVoteTest(){
    DomainManager manager = new DomainManager();
    User u1 = new User("Jonas", "Jonas@email.com");
    VoteOption o1 = new VoteOption("Vann", 1);
    Poll p1 = new Poll("Hva smaker best?", Instant.MAX, u1, List.of(o1));
    Vote v1 = new Vote(u1, o1);

    assertTrue(manager.addUser(u1));
    assertTrue(manager.addPoll(p1));
    assertTrue(manager.getUsers().size() == 1);
    assertTrue(manager.getUser(0).equals(u1));
    assertTrue(manager.getPolls().size() == 1);
    assertTrue(manager.getUser(0).getCreatedPolls().contains(p1));

    assertTrue(manager.castVote(p1, v1));
    assertTrue(u1.getVotes().contains(v1));
    assertTrue(p1.getVotes().contains(v1));
  }

  @Test
  public void removeUserTest(){
    DomainManager manager = new DomainManager();
    User u1 = new User("Jonas", "Jonas@email.com");
    Poll p1 = new Poll("Hva smaker best?", Instant.MAX, u1);

    assertTrue(manager.addUser(u1));
    assertTrue(manager.addPoll(p1));
    assertTrue(manager.getUsers().size() == 1);
    assertTrue(manager.getUser(0).equals(u1));
    assertTrue(manager.getPolls().size() == 1);
    assertTrue(manager.getUser(0).getCreatedPolls().contains(p1));
    assertTrue(manager.removeUser(0).equals(u1));
  }

  @Test
  public void removeVoteTest(){
    DomainManager manager = new DomainManager();
    User u1 = new User("Jonas", "Jonas@email.com");
    VoteOption o1 = new VoteOption("Vann", 1);
    Poll p1 = new Poll("Hva smaker best?", Instant.MAX, u1, List.of(o1));
    Vote v1 = new Vote(u1, o1);

    assertTrue(manager.addUser(u1));
    assertTrue(manager.addPoll(p1));
    assertTrue(manager.getUsers().size() == 1);
    assertTrue(manager.getUser(0).equals(u1));
    assertTrue(manager.getPolls().size() == 1);
    assertTrue(manager.getUser(0).getCreatedPolls().contains(p1));

    assertTrue(manager.castVote(p1, v1));
    assertTrue(u1.getVotes().contains(v1));
    assertTrue(p1.getVotes().contains(v1));
    assertTrue(manager.removeVote(p1, v1));
  }
}
