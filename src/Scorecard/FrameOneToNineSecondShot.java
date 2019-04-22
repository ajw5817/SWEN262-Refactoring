package Scorecard;

public class FrameOneToNineSecondShot implements FrameState{
  public void addScore(int score, Frame frame) {
    frame.addSecondShot(score);
    if(frame.getFrameScore() == 10){
      frame.updateState(new Spare());
    }
    else{
      frame.updateState(new Frameended());
    }
  }
  @Override
  public String[] assemble(Frame frame) {
    String[] assembled = new String[2];
    assembled[0] = Integer.toString(frame.getFirstShot());
    assembled[1] = " ";
    return assembled;
  }
}
