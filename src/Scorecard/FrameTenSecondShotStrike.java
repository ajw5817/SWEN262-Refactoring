package Scorecard;

public class FrameTenSecondShotStrike implements FrameState{
  public void addScore(int score, Frame frame) {
    frame.addSecondShot(score);
    frame.updateState(new FrameTenThirdShot());
  }
}
