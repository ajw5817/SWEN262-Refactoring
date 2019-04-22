package Scorecard;

public class Frameended implements FrameState {
  public void addScore(int score, Frame frame) {

  }

  @Override
  public String[] assemble(Frame frame) {
    String[] assembled;
    if(frame.getFrameNumber() != 10) {
      assembled = new String[2];
      assembled[0] = Integer.toString(frame.getFirstShot());
      assembled[1] = Integer.toString(frame.getfirstTwo() - frame.getFirstShot());
    }
    else{
      assembled = new String[3];
      assembled[0] = Integer.toString(frame.getFirstShot());
      assembled[1] = Integer.toString(frame.getfirstTwo()-frame.getFirstShot());
      assembled[2] = Integer.toString(frame.getFrameScore()-frame.getfirstTwo());
    }
    return assembled;
  }
}
