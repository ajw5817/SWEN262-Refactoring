import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import Scorecard.Scores;


public class Scorecard {
  private HashMap<String, Scores> scorecard;
  private int frame;
  private Iterator Bowlers;
  private Party party;

  private Bowler current;

  public Scorecard(Party party){
    this.Bowlers = party.getMembers().iterator();
    frame = 0;
    while(Bowlers.hasNext()){
      Bowler b = (Bowler)Bowlers.next();
      scorecard.put(b.getFullName(), new Scores(b.getFullName()));
    }
    this.party = party;
    nextFrame();
    current = (Bowler)Bowlers.next();
  }

  public int getCurrentBowlerScore(){
    return scorecard.get(current.getFullName()).getTotalScore();
  }
  public String getCurrentBowler(){
    return current.getFullName();
  }
  public int getCurrentFrame(){
    return frame;
  }
  public boolean isGameOver(){
    return frame == 10 && !Bowlers.hasNext();
  }

  public void reset(){
    scorecard.clear();
    frame = 0;
    Bowlers = party.getMembers().iterator();
    while(Bowlers.hasNext()){
      Bowler b = (Bowler)Bowlers.next();
      scorecard.put(b.getFullName(), new Scores(b.getFullName()));
    }
    nextFrame();
    current = (Bowler)Bowlers.next();

  }

  public void addScore(int score){
    Scores s = scorecard.get(current.getFullName());
    s.addScore(frame, score);
    update();
  }

  public void update(){
    if(scorecard.get(current.getFullName()).thruFrame() == frame && Bowlers.hasNext() && frame <= 10){
      current = (Bowler)Bowlers.next();
    }
    else if(!Bowlers.hasNext() && frame < 10){
      nextFrame();
      current = (Bowler)Bowlers.next();
    }

  }

  public void nextFrame(){
    frame ++;
    Bowlers = party.getMembers().iterator();
  }


}
