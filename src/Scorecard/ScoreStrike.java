package Scorecard;

import java.util.ArrayList;

public class ScoreStrike implements ScoreStrategy {
  public int getScore(ArrayList<Frame> frames, int frame){
    if(frames.get(frame).getState().getClass() == new Strike().getClass()){
      return 30 ;
    }
    else{
      return 10 + frames.get(frame).getfirstTwo();
    }
  }
}
