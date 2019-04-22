package Scorecard;

import java.util.ArrayList;

public class Scores {
  private ArrayList<Frame> frames;
  private String name;
  public Scores(String fullname){
    this.name = fullname;
    this.frames = new ArrayList<Frame>(10);
    for(int i = 1; i <= 10; i++){
      frames.add(new Frame(i));
    }
  }

  public void addScore(int frame, int score){
    frames.get(frame-1).addScore(score);
  }

  public int getFrameScore(int frame){
    ScoreStrategy scoreStrategy;
    FrameState fs = frames.get(frame).getState();
    if(fs.getClass() == new Strike().getClass()){
      scoreStrategy = new ScoreStrike();
    }
    else if(fs.getClass() == new Spare().getClass()){
      scoreStrategy = new ScoreSpare();
    }
    else{
      scoreStrategy = new Scored();
    }
    return scoreStrategy.getScore(frames, frame);
  }

  public int getTotalScore(){
    int i = 1;
    int score = 0;
    ScoreStrategy scoreStrategy;
    for(Frame f: frames){
      FrameState fs = f.getState();
      if(fs.getClass() == new Strike().getClass()){
        scoreStrategy = new ScoreStrike();
      }
      else if(fs.getClass() == new Spare().getClass()){
        scoreStrategy = new ScoreSpare();
      }
      else{
        scoreStrategy = new Scored();
      }
      score += scoreStrategy.getScore(frames, i);
      i++;
    }
    return score;
  }
  public int getCumScore(int frame){
    int i = 0;
    int score = 0;
    ScoreStrategy scoreStrategy;
    for(Frame f: frames){
      if(i == frame + 1){
        break;
      }
      FrameState fs = f.getState();
      if(fs.getClass() == new Strike().getClass()){
        scoreStrategy = new ScoreStrike();
      }
      else if(fs.getClass() == new Spare().getClass()){
        scoreStrategy = new ScoreSpare();
      }
      else{
        scoreStrategy = new Scored();
      }
      score += scoreStrategy.getScore(frames, i+1);
      i++;
    }
    return score;
  }

  public int thruFrame(){
    int thru = 0;
    for(Frame f: frames){
      if(f.getState().getClass() == new Spare().getClass() || f.getState().getClass() == new Strike().getClass() || f.getState().getClass() == new Frameended().getClass()){
        thru ++;
      }
    }
    return thru;
  }

  public Frame getFrame(int frame){
    return frames.get(frame);
  }
  /*

  public String[] assembleFrame(){
    String[] framed = new String[21];
    int j = 0;
    for(Frame f: frames){
      if(f.getState().getClass() == new Strike().getClass()){
        //framed[j] = "X";
        //framed[j+1] = " ";
        framed[j] = f.assemble()[0];
        framed[j+1] = f.assemble()[1];
      }
      else if(f.getState().getClass() == new Spare().getClass()){
        framed[j] = Integer.toString(f.getFirstShot());
        framed[j+1] = "/";
      }
      else if(f.getState().getClass() == new FrameOneToNineSecondShot().getClass()){
        framed[j] = Integer.toString(f.getFirstShot());
        framed[j+1] = " ";
      }
      else if(f.getState().getClass() == new Frameended().getClass()){
        framed[j] = Integer.toString(f.getFirstShot());
        framed[j+1] = Integer.toString(f.getfirstTwo() - f.getFirstShot());
      }
      else{
        framed[j] = " ";
        framed[j+1] = " ";
      }
      j += 2;
    }
    if(frames.get(9).getState().getClass() != new FrameTenFirstShot().getClass()){
      Frame f = frames.get(9);
      if(f.getFirstShot() == 10){
        framed[18] = "X";
      }
      if(f.getfirstTwo()-f.getFirstShot() == 10){
        framed[19] = "X";
      }
      if(f.getfirstTwo() == 10){
        framed[19] = "/";
      }
      if(f.getFrameScore()-f.getfirstTwo() == 10){
        framed[20] = "X";
      }
      else if(f.getState().getClass() == new Frameended().getClass() && f.getFrameScore()-f.getfirstTwo() == 0){

      }
      else if(f.getState().getClass() == new Frameended().getClass()){
        framed[20] = Integer.toString(f.getFrameScore()-f.getfirstTwo());
      }
      else{
        framed[18] = Integer.toString(f.getFirstShot());
      }
    }
    return framed;
  }
  */
  public String[] assembleFrame(){
    String[] framed = new String[21];
    int j = 0;
    for(Frame f: frames){
      String[] assembled = f.assemble();
      for(int i = 0; i < assembled.length; i++){
        framed[j] = assembled[i];
        j++;
      }
    }
    return framed;
  }

}
