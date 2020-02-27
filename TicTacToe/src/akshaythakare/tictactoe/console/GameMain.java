package akshaythakare.tictactoe.console;

import java.util.Scanner;

public class GameMain {
	
   private GameBoard board;// the game board
   private GameState currentState; // the current state of the game as enum
   private Marks currentPlayer;// the current player with Marks enum
 
   private static Scanner input = new Scanner(System.in);  // input Scanner
 
  
   
   public GameMain() {
      board = new GameBoard();
 
      // Initialize the game-board and current status
      
      initGame();
      
      // Play the game. Players X and O move alternately.
      
      do 
      {
         playerMove(currentPlayer); // update the content, currentRow and currentCol
         board.paint();             // ask the board to paint itself
         updateGame(currentPlayer); // update currentState
         
         // Print message if game-over
         if (currentState == GameState.CROSS_WON) 
         {
            System.out.println("'X' won! Bye!");
         } 
         else if (currentState == GameState.NOUGHT_WON) 
         {
            System.out.println("'O' won! Bye!");
         } 
         else if (currentState == GameState.DRAW) 
         {
            System.out.println("It's Draw! Bye!");
         }
         // Switch player
         currentPlayer = (currentPlayer == Marks.CROSS) ? Marks.NOUGHT : Marks.CROSS;
      } 
      while (currentState == GameState.PLAYING);  // repeat until game-over
   }
 
   
   public void initGame() 
   {
      board.init();  // clear the board contents
      currentPlayer = Marks.CROSS;
      currentState = GameState.PLAYING; // ready to play
   }
 
   /** The player with "theSeed" makes one move, with input validation.
       Update Cell's content, Board's currentRow and currentCol. */
   public void playerMove(Marks element) 
   {
      boolean validInput = false;  // for validating input
      do {
         if (element == Marks.CROSS) 
         {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } 
         else 
         {
            System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
         }
         
         int row = input.nextInt() - 1;
         int col = input.nextInt() - 1;
         
         if (row >= 0 && row < GameBoard.ROWS && col >= 0 && col < GameBoard.COLS
               && board.cells[row][col].mark == Marks.EMPTY) 
         {
            board.cells[row][col].mark = element;
            board.currRow = row;
            board.currCol = col;
            validInput = true; // input okay, exit loop
         } 
         else 
         {
            System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Retry!");
         }
      } while (!validInput);
   }
 
   /** Update the currentState after the player with "element" has moved */
   
   public void updateGame(Marks element) 
   {
      if (board.isWinner(element)) 
      {
    	  
         currentState = (element == Marks.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
      } 
      else if (board.checkDraw()) 
      {  // checking draw
         currentState = GameState.DRAW;
      }
      // Otherwise, no change to current state (still GameState.PLAYING).
   }
 
  
   public static void main(String[] args) 
   {
      new GameMain();  
   }
}
