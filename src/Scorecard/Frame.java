package Scorecard;

public class Frame {
  private int firstShot;
  private int secondShot;
  private int thirdShot;
  private int frameNumber;
  private FrameState state;
  public Frame(int frameNumber){
    firstShot = 0;
    secondShot = 0;
    thirdShot = 0;
    this.frameNumber = frameNumber;
    if(frameNumber <= 9) {
      this.state = new FrameOneToNineFirstShot();
    }
    else{
      this.state = new FrameTenFirstShot();
    }
  }

  public void addScore(int shot){
    state.addScore(shot, this);
  }

  protected void addFirstShot(int shot){
    this.firstShot = shot;
  }
  protected void addSecondShot(int shot){
    this.secondShot = shot;
  }
  protected void addThirdShot(int shot){
    this.thirdShot = shot;
  }

  public int getFrameScore(){
    return firstShot + secondShot + thirdShot;
  }
  public int getFirstShot(){
    return firstShot;
  }
  public int getfirstTwo(){
    return firstShot + secondShot;
  }

  protected void updateState(FrameState state){
    this.state = state;
  }
  public FrameState getState(){
    return state;
  }

  public int getFrameNumber() {
    return frameNumber;
  }
}
