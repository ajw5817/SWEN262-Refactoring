package Scorecard;

public class Spare implements FrameState {
  public void addScore(int score, Frame frame) {
  }
  @Override
  public String[] assemble(Frame frame) {
    String[] assembled = new String[2];
    assembled[0] = Integer.toString(frame.getFirstShot());
    assembled[1] = "/";
    return assembled;
  }
}

