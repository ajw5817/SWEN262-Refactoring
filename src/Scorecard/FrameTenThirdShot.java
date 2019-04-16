package Scorecard;

public class FrameTenThirdShot implements FrameState{
  public void addScore(int score, Frame frame) {
    frame.addThirdShot(score);
    frame.updateState(new Frameended());
  }
}
