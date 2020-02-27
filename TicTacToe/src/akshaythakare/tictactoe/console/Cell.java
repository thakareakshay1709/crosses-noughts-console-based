package akshaythakare.tictactoe.console;

/**
 * Cell class
 * @author akshaythakare
 *
 */
	public class Cell {  

		//// take a value of Marks.EMPTY, Marks.CROSS, or Marks.NOUGHT
	   Marks mark;
	// row and column of this cell
	   int row, col; 
	 

	   //Initialising cell
	   public Cell(int row, int col) {
	      this.row = row;
	      this.col = col;
	      clear();  // clear content
	   }
	 
	  //To make cells clear
	   public void clear() {
		   mark = Marks.EMPTY;
	   }
	 

	   public void fill() {
	      switch (mark) 
	      {
	         case CROSS:  
	        	 System.out.print(" X "); 
	        	 break;
	         case NOUGHT: 
	        	 System.out.print(" O "); 
	        	 break;
	         case EMPTY:  
	        	 System.out.print("   "); 
	        	 break;
	      }
	   }
	}

