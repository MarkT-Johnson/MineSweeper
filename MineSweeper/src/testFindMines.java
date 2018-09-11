
public class testFindMines {

	public static void main(String[] args) {
		Board testBoard = new Board(3, 3, 1);

		//Assigns mine positions
		for(int r = 0; r < testBoard.getIntBoard().length; r++){
			for(int c = 0; c < testBoard.getIntBoard()[0].length; c++){
				if(Math.random() > 0.9){
					testBoard.getIntBoard()[r][c] = 9;
				}
				else{
					testBoard.getIntBoard()[r][c] = 0;
				}
			}
		}

		System.out.println("Pre value assesment");

		printField(testBoard.getIntBoard());

		findMines(testBoard.getIntBoard());

		System.out.println("Post value assignment");

		printField(testBoard.getIntBoard());
	}

	private static void printField(int[][] board){

		for(int r = 0; r < board.length; r++){
			System.out.print("\n");
			for(int c = 0; c < board[0].length; c++){
				System.out.printf("%-3d", board[r][c]);
			}
		}
		System.out.println("\n");
	}

	//Count the number of mines touching each square
	private static void findMines(int[][] board){
		int mineCounter = 0;

		for(int r = 1; r < board.length - 1; r++){
			for(int c = 1 ; c < board[r].length - 1; c++){
				mineCounter = 0;
				for(int u = -1; u < 2; u++){
					for(int v = -1; v < 2; v++){
						if(9 != board[r][c] && 9 == board[r + u][c + v]){
							mineCounter++;
						}
					}
				}
				if( 9 != board[r][c]){
					board[r][c] = mineCounter;
				}
			}
		}
	}

}
