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
      if(frame.getFirstShot() == 10) {
        assembled[0] = "X";
        if(frame.getfirstTwo() == 20){
          assembled[1] = "X";
          if(frame.getFrameScore() == 30){
            assembled[2] = "X";
          }
        }

      }
      else if(frame.getfirstTwo() == 10) {
        assembled[0] = Integer.toString(frame.getFirstShot());
        assembled[1] = "/";
        assembled[2] = Integer.toString(frame.getFrameScore()-frame.getfirstTwo());
      }
      else{
        assembled[0] = Integer.toString(frame.getFirstShot());
        assembled[1] = Integer.toString(frame.getfirstTwo() - frame.getFirstShot());
        assembled[2] = Integer.toString(frame.getFrameScore()-frame.getfirstTwo());
      }
      if(frame.getFrameScore()-frame.getfirstTwo() == 10){
        assembled[2] = "X";
      }
    }
    return assembled;
  }
}
