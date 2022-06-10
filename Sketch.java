import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  float circleX;
  float circleY;
  float circleDiameter;

  boolean alive = true;
  int playerLives = 3;

  PImage imgBackground;
  PImage imgGameOver;
  PImage imgHomescreen;
  PImage imgLevelOne;
  PImage imgLevelTwo;
  PImage imgLevelThree;
  PImage imgOneLife;
  PImage imgScary;
  PImage imgYouWin;

  /*
  Screen 1 - Home Screen
  Screen 2 - Level 1
  Screen 3 - Level 2
  Screen 4 - Level 3
  Screen 5 - Game over
  Screen 6 - You Win!
   */
  int screen = 1;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    circleX = width;
    circleY = height;
    circleDiameter = 40;

    imgBackground = loadImage("background.jpeg");
    imgBackground.resize(800,800);
    imgGameOver = loadImage("gameover.png");
    imgHomescreen = loadImage("homescreen.jpg");
    imgHomescreen.resize(800,800);
    imgLevelOne = loadImage("level1.jpg");
    imgLevelOne.resize(800,800);
    imgLevelTwo = loadImage("level2.jpg");
    imgLevelTwo.resize(800,800);
    imgLevelThree = loadImage("level3.jpg");
    imgLevelThree.resize(800,800);
    imgOneLife = loadImage("onelife.png");
    imgScary = loadImage("scary.png");
    imgYouWin = loadImage("youwin.png");
    }

  public void draw() {
    if (screen == 1) {
      homeScreen();
    }
    if (screen == 2) {
      levelOne();
    }
    if (screen == 3) {
      levelTwo();
    }
    if (screen == 4) {
      levelThree();
    }
    if (screen == 5) {
      gameOver();
    }
    if (screen == 6) {
      youWin();
    }

    image(imgBackground, 0, 0);

    if (dist(mouseX, mouseY, circleX, circleY) < circleDiameter/2) {

      if (mousePressed) {
        // mouse is inside the circle and clicked. 
        circleX = mouseX;
        circleY = mouseY;
  
      } 
      else {
        mouseClicked(); {
    }
      }}
    
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
        ellipse(circleX, circleY, circleDiameter, circleDiameter);
          fill(0, 0, 255);
    }
  
  public void homeScreen() {
    background(imgHomescreen);

    fill(255); // White
    textSize(150);
    text("SCARY MAZE GAME", 50, 150);

    if ((mouseX >= 50 && mouseX <= 750) && (mouseY >= 300 && mouseY <= 350)) {
      fill(246, 255, 0); // Yellow
      rect(50, 300, 700, 50);
  
      fill(255); // Black
      textSize(50);
      text("PLAY", 55, 345);
  
      if (mousePressed == true) {
        screen = 2;
      }
    }
    else {
      mousePressed = false; {
      }
    } 
  }
}