package Scorecard;

public interface FrameState {
  public void addScore(int score, Frame frame);
  public String[] assemble(Frame frame);
}
