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
  @Override
  public String[] assemble(Frame frame) {
    String[] assembled = new String[3];
    assembled[0] = Integer.toString(frame.getFirstShot());
    assembled[1] = " ";
    assembled[2] = " ";
    return assembled;
  }
}
