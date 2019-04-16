package Scorecard;

import java.util.ArrayList;

public interface ScoreStrategy {
  public int getScore(ArrayList<Frame> frames, int frame);
}
