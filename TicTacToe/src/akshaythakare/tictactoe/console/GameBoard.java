package akshaythakare.tictactoe.console;

/**
 * The class represent the gameboard
 * @author akshaythakare
 *
 */
public class GameBoard {  
	
	
   public static final int ROWS = 3;
   public static final int COLS = 3;
 
   
   //Cell is composed of rows and columns instances
   Cell[][] cells;
   int currRow, currCol;//Marks of current placements row 
   
 
   /** Constructor to initialize the game board */
   public GameBoard() {
      cells = new Cell[ROWS][COLS];
      
      //Initialise the cells
      for (int i = 0; i < ROWS; ++i) 
      {
         for (int j = 0; j < COLS; ++j) 
         {
            cells[i][j] = new Cell(i, j);
         }
      }
   }
 
   /** 
    * Initialising current cells as empty
    *  */
   public void init() 
   {
      for (int row = 0; row < ROWS; ++row) 
      {
         for (int col = 0; col < COLS; ++col) 
         {
            cells[row][col].clear();
         }
      }
   }
 
   /** 
    * If no cells are empty and not any result, return true as its draw
    *
    **/
   public boolean checkDraw() 
   {
      for (int row = 0; row < ROWS; ++row) 
      {
         for (int col = 0; col < COLS; ++col) 
         {
            if (cells[row][col].mark == Marks.EMPTY) {
               return false; // an empty seed found, not a draw, exit
            }
         }
      }
      return true; // no empty cell, it's a draw
   }
 
   
   //Method is used to return true after placing the element in the cell
   public boolean isWinner(Marks element) 
   {
      return (		  cells[currRow][0].mark == element         // 3-in-the-row
                   && cells[currRow][1].mark == element
                   && cells[currRow][2].mark == element
                   
                   || cells[0][currRow].mark == element      // 3-in-the-column
                   && cells[1][currCol].mark == element
                   && cells[2][currCol].mark == element
                   
                   || currRow == currCol            // 3-in-the-diagonal
                   && cells[0][0].mark == element
                   && cells[1][1].mark == element
                   && cells[2][2].mark == element
                   
                   || currRow + currCol == 2    // 3-in-the-opposite-diagonal
                   && cells[0][2].mark == element
                   && cells[1][1].mark == element
                   && cells[2][0].mark == element);
   }
 
  
   public void paint() 
   {
      for (int row = 0; row < ROWS; ++row) 
      {
         for (int col = 0; col < COLS; ++col) 
         {
            cells[row][col].fill();   
            // each cell paints itself
            if (col < COLS - 1) System.out.print("|");
         }
         
         System.out.println();
         
         if (row < ROWS - 1) 
         {
            System.out.println("-----------");
         }
      }
   }
}
