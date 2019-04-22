package Scorecard;

public class Strike implements FrameState {
  public void addScore(int score, Frame frame) {

  }
  @Override
  public String[] assemble(Frame frame) {
    String[] assembled = new String[2];
    assembled[0] = "X";
    assembled[1] = " ";
    return assembled;
  }
}
