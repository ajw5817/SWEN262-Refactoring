package Scorecard;

public class FrameTenSecondShot implements FrameState{
  public void addScore(int score, Frame frame) {
    frame.addSecondShot(score);
    if(frame.getFrameScore() == 10){
      frame.updateState(new FrameTenThirdShot());
    }
    else{
      frame.updateState(new Frameended());
    }
  }
}
