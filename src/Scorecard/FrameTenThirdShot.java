package Scorecard;

public class FrameTenThirdShot implements FrameState{
  public void addScore(int score, Frame frame) {
    frame.addThirdShot(score);
    frame.updateState(new Frameended());
  }
  @Override
  public String[] assemble(Frame frame) {
    String[] assembled = new String[3];
    if(frame.getFirstShot() == 10) {
      assembled[0] = "X";
      if(frame.getfirstTwo() == 20){
        assembled[1] = "X";
      }
      else{
        assembled[1] = Integer.toString(frame.getfirstTwo()-frame.getFirstShot());
      }
    }
    else{
      assembled[0] = Integer.toString(frame.getFirstShot());
      assembled[1] = "/";
    }
    return assembled;
  }
}
