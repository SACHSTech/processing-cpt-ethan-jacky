import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {
  
  // setup of variables

  int circleXIndex;
  int circleYIndex;

  float unitWidth = width/rows;
  float unitHeight = width/columns;
  float unitX;
  float unitY;

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
               
  
  public void homeScreen() {
    background(imgHomescreen);

    // title
    fill(255,0,0); // Red
    textSize(70);
    text("SCARY MAZE GAME", 75, 150);

    fill(0); // Black
    rect(50, 600, 700, 50);
  
    fill(255,0,0); // Red
    textSize(50);
    text("PLAY", 55, 645); // starts the game if pressed

    if ((mouseX >= 50 && mouseX <= 800) && (mouseY >= 600 && mouseY <= 650)) {
      if (mousePressed == true) {
        screen = 2;
      }
    }
    else {
      mousePressed = false; {
      }
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
      screen = 2;

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
  
  
  