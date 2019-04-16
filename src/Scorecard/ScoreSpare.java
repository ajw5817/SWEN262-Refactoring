package Scorecard;

import java.util.ArrayList;

public class ScoreSpare implements ScoreStrategy {
  public int getScore(ArrayList<Frame> frames, int frame) {
    return 10 + frames.get(frame).getFirstShot();
  }
}
