import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import Scorecard.Scores;
import Scorecard.Frame;


public class Scorecard {
  private HashMap<String, Scores> scorecard;
  private int frame;
  private Iterator Bowlers;
  private Party party;
  private Bowler current;

  public Scorecard(Party party){
    this.scorecard = new HashMap<>();
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
  public int getBowlerScoreForFrame(Bowler bowler, int frame) {
    return scorecard.get(bowler.getFullName()).getFrameScore(frame);
  }
  public int getBowlerScoreCum(Bowler bowler, int frame){
    return scorecard.get(bowler.getFullName()).getCumScore(frame);
  }
  public int getBowlerScore(Bowler bowler){
    return scorecard.get(bowler.getFullName()).getTotalScore();
  }
  public int getCurrentBowlerScore(){
    return scorecard.get(current.getFullName()).getTotalScore();
  }

  public int getCertainBowlerScore(String fullName){
    return scorecard.get(fullName).getTotalScore();
  }
  public Bowler getCurrentBowler(){
    return current;
  }

  public int getCurrentFrame(){
    return frame;
  }

  public Frame getPlayerFrame(Bowler bowler, int frame){return scorecard.get(bowler.getFullName()).getFrame(frame);}
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
  }

  public void update(){
    if(scorecard.get(current.getFullName()).thruFrame() == frame && Bowlers.hasNext() && frame <= 10){
      current = (Bowler)Bowlers.next();
    }
    else if(!Bowlers.hasNext() && frame <= 10 && current.getFullName().equals(getNameatIndex(party.getMembers().size()-1))){
      nextFrame();
      current = (Bowler)Bowlers.next();
    }

  }

  public Iterator getBowlers() {
    return Bowlers;
  }

  public void nextFrame(){
    frame ++;
    Bowlers = party.getMembers().iterator();
  }

  public boolean hasNext(){
    if (current.getFullName().equals(getNameatIndex(party.getMembers().size()-1))) {
      return true;
    }
    return Bowlers.hasNext();
  }

  public String getNameatIndex(int index){
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

  public String[][] assembleFrames(){
    String[][] frames = new String[party.getMembers().size()][21];
    int i = 0;
    for(Object b: party.getMembers()){
      Bowler bowler = (Bowler)b;
      frames[i] = scorecard.get(bowler.getFullName()).assembleFrame();
      i+=1;
    }
    return frames;
  }

  public String[][] assembleCum(){
    String[][]cum = new String[party.getMembers().size()][10];
    int i = 0;
    for(Object b: party.getMembers()){
      Bowler bowler = (Bowler)b;
      Scores bs = scorecard.get(bowler.getFullName());
      for(int j = 1; j <= 10; j++) {
        cum[i][j] = Integer.toString(bs.getCumScore(j));
      }
      i+=1;
    }
    return cum;
  }
}
