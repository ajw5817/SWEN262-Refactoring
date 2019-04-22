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
  @Override
  public String[] assemble(Frame frame) {
    String[] assembled = new String[3];
    assembled[0] = " ";
    assembled[1] = " ";
    assembled[2] = " ";
    return assembled;
  }
}
