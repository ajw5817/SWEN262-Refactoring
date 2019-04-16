package Scorecard;

public class FrameTenFirstShot implements FrameState {
  public void addScore(int score, Frame frame) {
    frame.addFirstShot(score);
    if(score == 10) {
      frame.updateState(new FrameTenSecondShotStrike());
    }
    else{
      frame.updateState(new FrameTenSecondShot());
    }
  }
}
