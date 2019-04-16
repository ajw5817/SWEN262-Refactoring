package Scorecard;

import java.util.ArrayList;

public class Scores {
  private ArrayList<Frame> frames;
  private String name;
  public Scores(String fullname){
    this.name = fullname;
    this.frames = new ArrayList<Frame>(10);
    for(int i = 1; i <= 10; i++){
      frames.add(new Frame(i));
    }
  }

  public void addScore(int frame, int score){
    frames.get(frame-1).addScore(score);
  }

  public int getTotalScore(){
    int i = 1;
    int score = 0;
    ScoreStrategy scoreStrategy;
    for(Frame f: frames){
      FrameState fs = f.getState();
      if(fs.getClass() == new Strike().getClass()){
        scoreStrategy = new ScoreStrike();
      }
      else if(fs.getClass() == new Spare().getClass()){
        scoreStrategy = new ScoreSpare();
      }
      else{
        scoreStrategy = new Scored();
      }
      score += scoreStrategy.getScore(frames, i);
      i++;
    }
    return score;
  }

  public int thruFrame(){
    int thru = 0;
    for(Frame f: frames){
      if(f.getState().getClass() == new Spare().getClass() || f.getState().getClass() == new Strike().getClass() || f.getState().getClass() == new Frameended().getClass()){
        thru ++;
      }
    }
    return thru;
  }
}
