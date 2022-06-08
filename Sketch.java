import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  float circleX = 150;
  float circleY = 150;
  
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
  
    image(imgBackground, 0, -100);
    
        // circle moves accordingly to what arrow directions user presses
      if (keyPressed) {
        if (keyCode == UP) {
          circleY--;
        } 
        else if (keyCode == DOWN) {
          circleY++;
        } 
        else if(keyCode == LEFT){
          circleX--;
        }
        else if(keyCode == RIGHT){
         circleX++; 
        }
      }
      // draw circle
        ellipse(circleX, circleY, 30, 30);
          fill(0, 0, 255);
        
      

    }
  
  
}