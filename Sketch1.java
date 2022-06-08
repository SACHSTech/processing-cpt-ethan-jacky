import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {
  
  PImage imgBackground;
  PImage imgGameOver;
  PImage imgOneLife;
  PImage imgScary;
  PImage imgYouWin;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1000, 1000);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    imgBackground = loadImage("background.jpeg");
    imgBackground.resize(1000,1000);
    imgGameOver = loadImage("gameover.png");
    imgOneLife = loadImage("onelife.png");
    imgScary = loadImage("scary.png");
    imgYouWin = loadImage("youwin.png");
    }

  public void draw() {
  
    