import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {
  
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  float circleX;
  float circleY;
  float circleDiameter;

  boolean alive = true;
  int playerLives = 3;

  int timerOne = 60000;
  int timerTwo = 90000;
  int timerThree = 120000;

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

      timerOne--;
      System.out.println(timerOne);

      if (timerOne == 0) {
        playerLives = 0;
        screen = 5;
      }
    }
    if (screen == 3) {
      levelTwo();

      timerTwo--;
      System.out.println(timerTwo);

      if (timerTwo == 0) {
        playerLives = 0;
        screen = 5;
      }
    }
    if (screen == 4) {
      levelThree();

      timerThree--;
      System.out.println(timerThree);

      if (timerThree == 0) {
        playerLives = 0;
        screen = 5;
      }
    }
    if (screen == 5) {
      gameOver();
    }
    if (screen == 6) {
      youWin();
    }
  }
  
  public void homeScreen() {
    background(imgHomescreen);

    fill(255); // White
    textSize(70);
    text("SCARY MAZE GAME", 75, 150);

    if ((mouseX >= 0 && mouseX <= 800) && (mouseY >= 0 && mouseY <= 800)) {
      fill(246, 255, 0); // Yellow
      rect(50, 600, 700, 50);
  
      fill(255); // Black
      textSize(50);
      text("PLAY", 55, 645);
  
      if (mousePressed == true) {
        screen = 2;
      }
    }
    else {
      mousePressed = false; {
      }
    } 
  }

  public void levelOne() {
    background(imgLevelOne);

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

      if (playerLives == 3) {
          image(imgOneLife, 600, 10);
          image(imgOneLife, 660, 10);
          image(imgOneLife, 720, 10);
        }
      else if (playerLives == 2) {
          image(imgOneLife, 660, 10);
          image(imgOneLife, 720, 10);
        }
      else if (playerLives == 1) {
          image(imgOneLife, 720, 10);
        }
      else if (playerLives == 0) {
          screen = 5;
          }
  }

  public void levelTwo() {
    background(imgLevelTwo);

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

          if (playerLives == 3) {
            image(imgOneLife, 600, 10);
            image(imgOneLife, 660, 10);
            image(imgOneLife, 720, 10);
          }
        else if (playerLives == 2) {
            image(imgOneLife, 660, 10);
            image(imgOneLife, 720, 10);
          }
        else if (playerLives == 1) {
            image(imgOneLife, 720, 10);
          }
        else if (playerLives == 0) {
            screen = 5;
            }
    }

  public void levelThree() {
    background(imgLevelThree);

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

          if (playerLives == 3) {
            image(imgOneLife, 600, 10);
            image(imgOneLife, 660, 10);
            image(imgOneLife, 720, 10);
          }
        else if (playerLives == 2) {
            image(imgOneLife, 660, 10);
            image(imgOneLife, 720, 10);
          }
        else if (playerLives == 1) {
            image(imgOneLife, 720, 10);
          }
        else if (playerLives == 0) {
            screen = 5;
            }
    }

  public void gameOver() {
    background(imgBackground);
    image(imgGameOver, 220, 50);
    image(imgScary, 100, 100);
    image(imgScary, 700, 100);

  if ((mouseX >= 50 && mouseX <= 750) && (mouseY >= 300 && mouseY <= 350)) {
    fill(1, 94, 41); // Green
    rect(50, 300, 700, 50);

    fill(0); // Black
    textSize(50);
    text("TRY AGAIN", 55, 345);

    if (mousePressed == true) {
      timerOne = 60;
      timerTwo = 90;
      timerThree = 120;
      alive = true;
      playerLives = 3;
      circleX = 200;
      circleY = 400;
      upPressed = false;
      downPressed = false;
      leftPressed = false;
      rightPressed = false;
      screen = 2;
    }
  }
  else {
    fill(0); // Black
    rect(50, 300, 700, 50);

    fill(1, 94, 41); // Green
    textSize(50);
    text("TRY AGAIN", 55, 345);
  }
  

  if ((mouseX >= 50 && mouseX <= 750) && (mouseY >= 550 && mouseY <= 600)) {
    fill(0, 8, 150); // Blue
    rect(50, 550, 700, 50);

    fill(0); // Black
    textSize(50);
    text("NO", 55, 595);

    if (mousePressed == true) {
      screen = 1;
    }
  }
  else {
    fill(0); // Black
    rect(50, 550, 700, 50);

    fill(0, 8, 150); // Blue
    textSize(50);
    text("NO", 55, 595);
  }
  
 }

  public void youWin() {
    background(255);
    image(imgYouWin, 220, 220);

    if ((mouseX >= 50 && mouseX <= 750) && (mouseY >= 300 && mouseY <= 350)) {
      fill(1, 94, 41); // Green
      rect(50, 300, 700, 50);
  
      fill(0); // Black
      textSize(50);
      text("TRY AGAIN", 55, 345);
  
      if (mousePressed == true) {
        timerOne = 60;
        timerTwo = 90;
        timerThree = 120;
        alive = true;
        playerLives = 3;
        circleX = 200;
        circleY = 400;
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
        screen = 2;
      }
    }
    else {
      fill(0); // Black
      rect(50, 300, 700, 50);
  
      fill(1, 94, 41); // Green
      textSize(50);
      text("TRY AGAIN", 55, 345);
    }
    
  
    if ((mouseX >= 50 && mouseX <= 750) && (mouseY >= 550 && mouseY <= 600)) {
      fill(0, 8, 150); // Blue
      rect(50, 550, 700, 50);
  
      fill(0); // Black
      textSize(50);
      text("NO THANKS", 55, 595);
  
      if (mousePressed == true) {
        screen = 1;
      }
    }
    else {
      fill(0); // Black
      rect(50, 550, 700, 50);
  
      fill(0, 8, 150); // Blue
      textSize(50);
      text("NO THANKS", 55, 595);
    }
  }
}