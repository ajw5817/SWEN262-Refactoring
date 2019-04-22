package Scorecard;

public class FrameTenSecondShotStrike implements FrameState{
  public void addScore(int score, Frame frame) {
    frame.addSecondShot(score);
    frame.updateState(new FrameTenThirdShot());
  }
  @Override
  public String[] assemble(Frame frame) {
    String[] assembled = new String[2];
    assembled[0] = "X";
    assembled[1] = " ";
    assembled[2] = " ";
    return assembled;
  }
}
