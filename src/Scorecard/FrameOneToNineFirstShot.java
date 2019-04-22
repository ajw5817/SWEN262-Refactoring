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
  @Override
  public String[] assemble(Frame frame) {
    String[] assembled = new String[2];
    assembled[0] = " ";
    assembled[1] = " ";
    return assembled;
  }
}
