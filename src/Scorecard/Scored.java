package Scorecard;

import java.util.ArrayList;

public class Scored implements ScoreStrategy {
  @Override
  public int getScore(ArrayList<Frame> frames, int frame) {
    return frames.get(frame-1).getFrameScore();
  }
}
