package com.oblig1.o1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.oblig1.o1.models.Poll;
import com.oblig1.o1.models.User;
import com.oblig1.o1.models.Vote;
import com.oblig1.o1.models.VoteOption;

/**
 * PollTest
 */
public class PollTest {

  private User jonas;
  private User katrine;
  private VoteOption option1;
  private VoteOption option2;
  private Poll p1;

  @BeforeEach
  public void SetUp(){
    this.jonas = new User("Jonas", "Jonas@email.com");
    this.katrine = new User("Katrine", "Katrine@gmail.com");
    this.option1 = new VoteOption("Melk", 1);
    this.option2 = new VoteOption("Vann", 2);
    this.p1 = new Poll("Hva smaker best?", Instant.ofEpochSecond(9999999), this.jonas, List.of(option1,option2));
  }

  @Test
  public void TestCreatePoll(){
    Poll createdPoll = new Poll("Hva smaker best?", Instant.MAX, this.katrine, List.of(option1,option2));
    assertTrue(createdPoll.getCreator().equals(this.katrine));
    assertTrue(this.katrine.getCreatedPolls().size() == 1);
    assertTrue(this.katrine.getCreatedPolls().contains(createdPoll));
    assertTrue(createdPoll.getVotes().size() == 0);
    assertTrue(createdPoll.getOptions().contains(option1));
    assertTrue(createdPoll.getOptions().contains(option2));
    assertTrue(createdPoll.getOptions().size() == 2);
    assertTrue(createdPoll.getPublishedAt().compareTo(Instant.now()) <= 1);
  }

  @Test
  public void TestVoting(){
    Vote vannVote = new Vote(this.jonas, this.option1);
    Vote melkVote = new Vote(this.katrine, this.option2);
    Vote fakeVote = new Vote(this.jonas, new VoteOption("Fake", 3));
    assertTrue(p1.vote(vannVote));
    assertFalse(p1.vote(fakeVote));
    assertFalse(p1.getVotes().contains(fakeVote));
    assertFalse(this.jonas.getVotes().contains(fakeVote));
    assertTrue(p1.getVotes().contains(vannVote));
    assertTrue(jonas.getVotes().contains(vannVote));
    assertFalse(jonas.getVotes().contains(melkVote));
    assertTrue(jonas.getVotes().size() == 1);
    assertTrue(p1.getVotes().size() == 1);

    assertTrue(p1.vote(melkVote));
    assertTrue(p1.getVotes().contains(melkVote));
    assertTrue(p1.getVotes().size() == 2);
    assertTrue(katrine.getVotes().contains(melkVote));
    assertFalse(katrine.getVotes().contains(vannVote));
    assertTrue(katrine.getVotes().size() == 1);
  }
}
