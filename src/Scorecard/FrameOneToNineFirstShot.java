package Scorecard;

public class FrameOneToNineFirstShot implements FrameState {
  public void addScore(int score, Frame frame){
    frame.addFirstShot(score);
    if(score == 10){
      frame.updateState(new Strike());
    }
    else{
      frame.updateState(new FrameOneToNineSecondShot());
    }
  }
}
