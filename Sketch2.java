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
               
  

 
      
      circleXIndex = (int) circleX/50;
      circleYIndex = (int) circleY/50;

  
      circleXIndex = (int) circleX/50;
      circleYIndex = (int) circleY/50;
        
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
  
  
  

