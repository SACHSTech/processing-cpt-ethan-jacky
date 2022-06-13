import processing.core.PApplet;
import processing.core.PImage;
import java.util.HashMap;

public class Sketch extends PApplet {
  
  int rows = 16;
  int columns = 16;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  float circleXOne;
  float circleYOne;
  float circleXTwo;
  float circleYTwo;
  float circleXThree;
  float circleYThree;
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

  HashMap<Float, Float> obstacles1 = new HashMap<Float, Float>();
  HashMap<Float, Float> obstacles2 = new HashMap<Float, Float>();
  HashMap<Float, Float> obstacles3 = new HashMap<Float, Float>();

   // level design (0 = empty, 1 = filled in)
  int [][] grid1 = { {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,3,3,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,3,3,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1},
                     {1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1},
                     {1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1},
                     {1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, };
  
  int [][] grid2 = { {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, };

  int [][] grid3 = { {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, };                 
               
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

    obstaclesPos1();
    obstaclesPos2();
    obstaclesPos3();

    circleXOne = 268;
    circleYOne = 650;
    circleXTwo = 600;
    circleYTwo = 250;
    circleXThree = 150;
    circleYThree = 650;
    circleDiameter = 25;
    
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
     levels(grid1, obstacles1);

    if (dist(mouseX, mouseY, circleXOne, circleYOne) < circleDiameter/2) {

      if (mousePressed) {
        // mouse is inside the circle and clicked. 
        circleXOne = mouseX;
        circleYOne = mouseY;
  
      } 
      else {
        mouseClicked(); {
    }
      }}
    
        // circle moves accordingly to what arrow directions user presses
      if (keyPressed) {
        if (keyCode == UP) {
          circleYOne--;
        } 
        else if (keyCode == DOWN) {
          circleYOne++;
        } 
        else if(keyCode == LEFT){
          circleXOne--;
        }
        else if(keyCode == RIGHT){
         circleXOne++; 
         System.out.println("penis");
        }
      }
      // draw circle
        ellipse(circleXOne, circleYOne, circleDiameter, circleDiameter);
          fill(0, 0, 255);

      if (playerLives == 3) {
          image(imgOneLife, 640, 10);
          image(imgOneLife, 700, 10);
          image(imgOneLife, 760, 10);
        }
      else if (playerLives == 2) {
          image(imgOneLife, 700, 10);
          image(imgOneLife, 760, 10);
        }
      else if (playerLives == 1) {
          image(imgOneLife, 760, 10);
        }
      else if (playerLives == 0) {
          screen = 5;
          }
  }

  public void levelTwo() {
     levels(grid2, obstacles2);

    if (dist(mouseX, mouseY, circleXTwo, circleYTwo) < circleDiameter/2) {

      if (mousePressed) {
        // mouse is inside the circle and clicked. 
        circleXTwo = mouseX;
        circleYTwo = mouseY;
  
      } 
      else {
        mouseClicked(); {
    }
      }}
    
        // circle moves accordingly to what arrow directions user presses
      if (keyPressed) {
        if (keyCode == UP) {
          circleYTwo--;
        } 
        else if (keyCode == DOWN) {
          circleYTwo++;
        } 
        else if(keyCode == LEFT){
          circleXTwo--;
        }
        else if(keyCode == RIGHT){
         circleXTwo++; 
        }
      }
      // draw circle
        ellipse(circleXTwo, circleYTwo, circleDiameter, circleDiameter);
          fill(0, 0, 255);

      if (playerLives == 3) {
            image(imgOneLife, 640, 10);
            image(imgOneLife, 700, 10);
            image(imgOneLife, 760, 10);
          }
      else if (playerLives == 2) {
            image(imgOneLife, 700, 10);
            image(imgOneLife, 760, 10);
          }
      else if (playerLives == 1) {
            image(imgOneLife, 760, 10);
          }
      else if (playerLives == 0) {
            screen = 5;
            }
    }

  public void levelThree() {
     levels(grid3, obstacles3);

    if (dist(mouseX, mouseY, circleXThree, circleYThree) < circleDiameter/2) {

      if (mousePressed) {
        // mouse is inside the circle and clicked. 
        circleXThree = mouseX;
        circleYThree = mouseY;
  
      } 
      else {
        mouseClicked(); {
    }
      }}
    
        // circle moves accordingly to what arrow directions user presses
      if (keyPressed) {
        if (keyCode == UP) {
          circleYThree--;
        } 
        else if (keyCode == DOWN) {
          circleYThree++;
        } 
        else if(keyCode == LEFT){
          circleXThree--;
        }
        else if(keyCode == RIGHT){
         circleXThree++; 
        }
      }
      // draw circle
        ellipse(circleXThree, circleYThree, circleDiameter, circleDiameter);
          fill(0, 0, 255);

      if (playerLives == 3) {
            image(imgOneLife, 640, 10);
            image(imgOneLife, 700, 10);
            image(imgOneLife, 760, 10);
          }
      else if (playerLives == 2) {
            image(imgOneLife, 700, 10);
            image(imgOneLife, 760, 10);
          }
      else if (playerLives == 1) {
            image(imgOneLife, 760, 10);
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
      timerOne = 1800;
      timerTwo = 90;
      timerThree = 120;
      alive = true;
      playerLives = 3;
      circleXOne = 200;
      circleYOne = 400;
      circleXTwo = 200;
      circleYTwo = 400;
      circleXThree = 200;
      circleYThree = 400;
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
        timerOne = 1800;
        timerTwo = 90;
        timerThree = 120;
        alive = true;
        playerLives = 3;
        circleXOne = 200;
        circleYOne = 400;
        circleXTwo = 200;
        circleYTwo = 400;
        circleXThree = 200;
        circleYThree = 400;
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
   /**
  * Draws the levels 
  * 
  * @param level  the level to be played (1,2,3)
  * @param obstaclePos  the positions of the obstacles
  */
  public void levels(int [][] level, HashMap<Float, Float> obstaclePos) {
    // interval for obstacle appearing
    if (count == 165) {
      count = 0;
    }
    count++;
    // 60 iterations = 1 second
    if (count2 == 60) {
      seconds++;
      count2 = 0;
    }
    count2++;
    if(seconds == 60) {
      minutes++;
      seconds = 0;
    }

    // draw grid
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        unitX = unitWidth * i;
        unitY = unitHeight * j;

        // fill the walls in
        if (level[j][i] == 1) {
          fill(1);
        } 
        else {
          noFill();
        }
        rect(unitX, unitY, unitWidth, unitHeight);

        // fill the obstacles in
        if (difficulty == "Easy") {
          if (count >= 0 && count <= 100) {
            obstacles(obstaclePos);
          }
        }
        else if (difficulty == "Hard") {
          if (count >= 0 && count <= 140) {
            obstacles(obstaclePos);
          }
        }
      }
    }
}