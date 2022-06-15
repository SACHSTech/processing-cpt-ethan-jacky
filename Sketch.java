import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  
  // setup of variables

  int rows = 16;
  int columns = 16;
  int width = 800;
  int height = 800;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  boolean gameRunning = true;
  
  float circleX;
  float circleY;
  float circleDiameter;

  int circleXIndex;
  int circleYIndex;

  float unitWidth = width/rows;
  float unitHeight = width/columns;
  float unitX;
  float unitY;

  boolean alive = true;
  int playerLives = 3;

  int timerOne;
  int timerTwo;
  int timerThree;
  
  PImage imgBackground;
  PImage imgHomescreen;
  PImage imgOneLife;
  PImage imgYouWin;

   // level design (0, 2, 3 = empty, 1 = filled in)
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
                     {1,0,0,0,0,1,1,1,2,2,2,0,0,0,0,1},
                     {1,0,1,0,0,1,1,1,2,2,2,0,0,0,0,1},
                     {1,0,1,0,0,1,1,1,2,2,2,1,1,0,0,1},
                     {1,0,1,0,0,1,1,1,1,1,1,1,1,0,0,1},
                     {1,0,1,0,0,1,0,0,0,0,0,1,1,0,0,1},
                     {1,0,1,0,0,1,0,0,0,0,0,1,1,0,0,1},
                     {1,0,1,0,0,1,0,0,1,0,0,1,1,0,0,1},
                     {1,0,1,0,0,1,0,0,1,0,0,1,1,0,0,1},
                     {1,0,1,0,0,1,0,0,1,0,0,1,1,0,0,1},
                     {1,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1},
                     {1,3,1,0,0,0,0,0,1,0,0,0,0,0,0,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, };

  int [][] grid3 = { {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                     {1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
                     {1,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1},
                     {1,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1},
                     {1,0,0,1,1,0,0,1,0,1,0,0,0,1,0,1},
                     {1,0,0,1,1,0,0,1,0,1,1,1,1,1,0,1},
                     {1,0,0,1,1,0,0,1,0,1,1,1,3,1,0,1},
                     {1,0,0,1,1,0,0,1,0,1,1,1,0,1,0,1},
                     {1,0,0,1,1,0,0,1,0,0,0,1,0,1,0,1},
                     {1,0,0,1,1,0,0,1,1,1,0,1,0,1,0,1},
                     {1,2,2,1,1,0,0,1,1,1,0,1,0,1,0,1},
                     {1,2,2,1,1,0,0,0,0,0,0,1,0,0,0,1},
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

    timerOne = 2080;
    timerTwo = 2580;
    timerThree = 3580;

    circleDiameter = 50;
  // images
    imgBackground = loadImage("background.jpg");
    imgBackground.resize(800,800);
    imgHomescreen = loadImage("homescreen.jpg");
    imgHomescreen.resize(800,800);
    imgOneLife = loadImage("onelife.png");
    imgYouWin = loadImage("youwin.png");
    imgYouWin.resize(800,800);
    }

  public void draw() {

    // methods to set individual screens for levels
    if (gameRunning) {
      if (screen == 1) {
        homeScreen();
        
      }
      if (screen == 2) {
        levelOne();
        
        // timer for level one
       
        timerOne--;
        if (timerOne == 0) {
         playerLives = 0;
         screen = 5;
        
        // prompts user to press character when not pressed to finish the level faster
        while (mousePressed = false);
          fill(255); // White
          textSize(40);
          text("PLEASE PRESS CHARACTER", 250, 150);
        
       }
      }
      if (screen == 3) {
        levelTwo();
        
      // timer for level 2
        timerTwo--;
        if (timerTwo == 0) {
          playerLives = 0;
          screen = 5;

        // prompts user to press character when not pressed to finish the level faster
        while (mousePressed = false);
          fill(255); // White
          textSize(40);
          text("PLEASE PRESS CHARACTER", 250, 150);
        
       
        }
      }
      if (screen == 4) {
        levelThree();

        // timer for level three
        timerThree--;
        if (timerThree == 0) {
          playerLives = 0;
          screen = 5;

        // prompts user to press character when not pressed to finish the level faster
        while (mousePressed = false);
          fill(255); // White
          textSize(40);
          text("PLEASE PRESS CHARACTER", 250, 150);
        
        
        }
      }
      if (screen == 5) {
        gameOver(); // this screen appears when the player loses the game
      }
      if (screen == 6) {
        youWin(); // this screen appears when the player wins the game
      }
    }
  } 
  public void homeScreen() {
    background(imgHomescreen);

    // title
    fill(255,0,0); // Red
    textSize(70);
    text("SCARY MAZE GAME", 75, 150);

    if ((mouseX >= 0 && mouseX <= 800) && (mouseY >= 0 && mouseY <= 800)) {
      fill(0); // Black
      rect(50, 600, 700, 50);
  
      fill(255,0,0); // Red
      textSize(50);
      text("PLAY", 55, 645); // starts the game if pressed
  
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
     levels(grid1);
     fill(255); // Black
     textSize(30);

     // timer
     text("LEVEL 1", 20, 50);
     text("TIME: ", 350, 50);
     text(timerOne/100, 450, 50);


    if (dist(mouseX, mouseY, circleX, circleY) < circleDiameter/2) 

      if (mousePressed) {
        // mouse is inside the circle and clicked. 
        circleX = mouseX;
        circleY = mouseY;
  
      } 
      else {
        mouseClicked(); {
        }
      }
      
      circleXIndex = (int) circleX/50;
      circleYIndex = (int) circleY/50;

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
        else {
          keyReleased();
        }
      }
      // draw circle
      ellipse(circleX, circleY, circleDiameter, circleDiameter);
        fill(255);

          // visible player lives
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
     levels(grid2);
     fill(255); // Black
     textSize(30);

     // timer
     text("LEVEL 2", 20, 50);
     text("TIME: ", 350, 50);
     text(timerTwo/100, 450, 50);
     

    if (dist(mouseX, mouseY, circleX, circleY) < circleDiameter/2) {

      if (mousePressed) {
        // mouse is inside the circle and clicked. 
        circleX = mouseX;
        circleY = mouseY;
  
      } 
      else {
        mouseClicked(); {
    }
      }
    }
        circleXIndex = (int) circleX/50;
        circleYIndex = (int) circleY/50;
        
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

          // visible player lives
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
     levels(grid3);
     fill(255); // Black
     textSize(30);

     // timer
     text("LEVEL 3", 20, 50);
     text("TIME: ", 350, 50);
     text(timerThree/100, 450, 50);
    

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

      circleXIndex = (int) circleX/50;
      circleYIndex = (int) circleY/50;
    
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

          // visible player lives
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

  if ((mouseX >= 50 && mouseX <= 750) && (mouseY >= 200 && mouseY <= 250)) {
    fill(0,255,255); // Cyan
    rect(50, 200, 700, 50);

    fill(0); // Black
    textSize(50);
    text("TRY AGAIN", 55, 245); // allows user to try again

    // game is resetted and back to the beginning
    if (mousePressed == true) {
      timerOne = 2080;
      timerTwo = 2580;
      timerThree = 3580;
      alive = true;
      playerLives = 3;
      upPressed = false;
      downPressed = false;
      leftPressed = false;
      rightPressed = false;
      screen = 1;
      homeScreen();
    }
  }
  else {
    fill(0); // Black
    rect(50, 200, 700, 50);

    fill(0,255,255); // Cyan
    textSize(50);
    text("TRY AGAIN", 55, 245);
  }
  

  if ((mouseX >= 50 && mouseX <= 750) && (mouseY >= 550 && mouseY <= 600)) {
    fill(255,0,0); // Red
    rect(50, 550, 700, 50);

    fill(0); // Black
    textSize(50);
    text("NO", 55, 595); // user doesn't want to try again

    if (mousePressed == true) {
      timerOne = 2080;
      timerTwo = 2580;
      timerThree = 3580;
      alive = true;
      playerLives = 3;
      upPressed = false;
      downPressed = false;
      leftPressed = false;
      rightPressed = false;
      screen = 1;
      homeScreen();
    }
  }
  else {
    fill(0); // Black
    rect(50, 550, 700, 50);

    fill(255,0,0); // Red
    textSize(50);
    text("NO", 55, 595);
  }
  
 }

  public void youWin() {
    background(imgYouWin);
  

    if ((mouseX >= 50 && mouseX <= 750) && (mouseY >= 200 && mouseY <= 250)) {
      fill(0,255,255); // Cyan
      rect(50, 200, 700, 50);
  
      fill(0); // Black
      textSize(50);
      text("PLAY AGAIN", 55, 245); // allows user to try again
  
      if (mousePressed == true) {
        timerOne = 2080;
        timerTwo = 2580;
        timerThree = 3580;
        alive = true;
        playerLives = 3;
        upPressed = false;
        downPressed = false;
        leftPressed = false;
        rightPressed = false;
        screen = 2;
        levelOne();
      }
    }
    else {
      fill(0); // Black
      rect(50, 200, 700, 50);
  
      fill(0,255,255); // Cyan
      textSize(50);
      text("PLAY AGAIN", 55, 245);
    }
    
  
    if ((mouseX >= 50 && mouseX <= 750) && (mouseY >= 550 && mouseY <= 600)) {
      fill(255,0,0); // Red
      rect(50, 550, 700, 50);
  
      fill(0); // Black
      textSize(50);
      text("NO THANKS", 55, 595); // user doesn't want to try again
  
      if (mousePressed == true) {
        screen = 1;
        homeScreen();
      }
    }
    else {
      fill(0); // Black
      rect(50, 550, 700, 50);
  
      fill(255,0,0); // Red
      textSize(50);
      text("NO THANKS", 55, 595);
    }
  }
   /**
  * Draws the levels 
  * 
  * @param level  the level to be played (1,2,3)
  * 
  *
  */

  public void levels(int [][] level) {
    // draw grid
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        unitX = unitWidth * i;
        unitY = unitHeight * j;

        // fill the walls in
        if (level[j][i] == 0) {
          fill(0, 255, 255); // Cyan
          noStroke();
        } 
        else if(level[j][i] == 2) {
          fill(255,218,185); // Tan
          noStroke();
        }
        else if(level[j][i] == 3) {
          fill(255, 0, 0); // Red
          noStroke();
        }
        else {
          fill(1); // Black
          noStroke();
        }
        rect(unitX, unitY, unitWidth, unitHeight);
      }
    }

    if (screen == 2) {
    
    
      if (grid1[circleYIndex][circleXIndex] == 1) {
        // deduct a player life and reset circle position if it goes on index 1 on the grid
        circleX = 250;
        circleY = 650;
        playerLives--;
      }
       // goes to screen 3 if circle goes on index 3 
        else if (grid1[circleYIndex][circleXIndex] == 3) {
        screen = 3;
       
        }
      }
    if (screen == 3) {
      if (grid2[circleYIndex][circleXIndex] == 1) {
        // deduct a player life and reset circle position if it goes on index 1 on the grid
          playerLives--;
          circleX = 485;
          circleY = 175;
      }
        // goes to screen 4 if circle goes on index 3
        else if (grid2[circleYIndex][circleXIndex] == 3) {
        screen = 4;
      
        }
      }

      
      if (screen == 4) {
        if (grid3[circleYIndex][circleXIndex] == 1) {
          // deduct a player life and reset circle position if circle goes on index 1 on the grid
          playerLives--;
          circleX = 100;
          circleY = 640;
      }   
          // goes to screen 6 if circle goes on index 3
          else if (grid3[circleYIndex][circleXIndex] == 3) {
          screen = 6;
    
          }
        }
      }
    }
  
  
  

