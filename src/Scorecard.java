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
  private int index;
  private Bowler current;

  public Scorecard(Party party){
    this.scorecard = new HashMap<>();
    this.Bowlers = party.getMembers().iterator();
    frame = 0;
    this.index = 0;
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
  public Bowler getCurrentBowler(){
    return current;
  }

  public int getCurrentIndex(){
    return index;
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
    index = 0;
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
      index++;
    }
    else if(!Bowlers.hasNext() && frame < 10){
      nextFrame();
      current = (Bowler)Bowlers.next();
      index = 0;
    }

  }

  public void nextFrame(){
    frame ++;
    Bowlers = party.getMembers().iterator();
  }

  public boolean hasNext(){
    return Bowlers.hasNext();
  }

  private String getNameatIndex(int index){
    int i = 0;
    Iterator<Bowler> j = party.getMembers().iterator();
    String name = " ";
    while(j.hasNext()){
      if(i == index){
         name = j.next().getFullName();
      }
      else{
        j.next();
      }
      i ++;
    }
    return name;
  }
}
