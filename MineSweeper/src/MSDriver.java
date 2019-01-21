import java.util.Scanner;

/* Board Key
 * -1 = unopened
 * 0 = unoccupied
 * 1-8 = # of mines
 * 9 = mine
 */

/* Action Keys
 * 0 = activate
 * 1 = flag
 */

public class MSDriver {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args){
		Board playerField = new Board(7, 7, 1);
		Board compField = new Board(7, 7, 1);
		Board checkField = new Board(7, 7, true);
		int totalMines = 0;
		int foundMines = 0;
		boolean dead = false;
		boolean exit = false;
		boolean firstMove = true;
		
		//=========================================================================================

		//Set all elements in checkField to false
		for(int r = 1; r < checkField.getBolBoard().length - 1; r++){
			for(int c = 1; c < checkField.getBolBoard()[0].length - 1; c++){
				checkField.getBolBoard()[r][c] = false;
			}
		}

		//---------------------------------------------------------------------
		
		//set values for playersField
		for(int r = 1; r < playerField.getIntBoard().length - 1; r++){
			for(int c = 1; c < playerField.getIntBoard()[0].length - 1; c++){
				playerField.getIntBoard()[r][c] = -1;
			}
		}
		
		//---------------------------------------------------------------------

		printField(playerField.getIntBoard());

		//Sets all values in checkField to true to begin the wall
		for(int r = 0; r < checkField.getBolBoard().length; r++){
			for(int c = 0; c < checkField.getBolBoard()[0].length; c++){
				checkField.getBolBoard()[r][c] = true;
			}
		}
		
		//---------------------------------------------------------------------
		
		//Sets all the inner values of checkField to false to make a ring of true around them
		//finally creating the wall in completion
		for(int r = 1; r < checkField.getBolBoard().length - 1; r++){
			for(int c = 1; c < checkField.getBolBoard()[0].length - 1; c++){
				checkField.getBolBoard()[r][c] = false;
			}
		}
		
		//---------------------------------------------------------------------

		//Set mine positions for the computer board
		for(int r = 1; r < compField.getIntBoard().length - 1; r++){
			for(int c = 1; c < compField.getIntBoard()[0].length - 1; c++){
				if(Math.random() > 0){
					compField.getIntBoard()[r][c] = 9;
					totalMines++;
				}
				else{
					compField.getIntBoard()[r][c] = 0;
				}
			}
		}
		
		//---------------------------------------------------------------------

		//Assign Number of mines to unoccupied squares
		findMines(compField.getIntBoard());

		//=========================================================================================
		
		//Game Play begins
		while(!exit && foundMines < totalMines){
			int[] playersMove = playersMove(playerField.getIntBoard());

			if(playersMove[2] == 0  && 9 == compField.getIntBoard()[playersMove[0]][playersMove[1]]){
				
				//Removes players chance to hit mine on first play
				if(firstMove) {
					compField.getIntBoard()[playersMove[0]][playersMove[1]] = 0;
					findMines(compField.getIntBoard());
					firstMove = false;
					
					if(0 == compField.getIntBoard()[playersMove[0]][playersMove[1]]){
						clearEmpty(playersMove[0], playersMove[1], compField.getIntBoard(), playerField.getIntBoard(), checkField.getBolBoard());
					}
					else{
						playerField.getIntBoard()[playersMove[0]][playersMove[1]] = compField.getIntBoard()[playersMove[0]][playersMove[1]];
					}
					printField(playerField.getIntBoard());
				}
				else {
					dead = true;
					exit = true;
				}
				

			}
			else if(playersMove[2] == 0){
				if(firstMove) {
					firstMove = !firstMove;
				}
				if(0 == compField.getIntBoard()[playersMove[0]][playersMove[1]]){
					clearEmpty(playersMove[0], playersMove[1], compField.getIntBoard(), playerField.getIntBoard(), checkField.getBolBoard());
				}
				else{
					playerField.getIntBoard()[playersMove[0]][playersMove[1]] = compField.getIntBoard()[playersMove[0]][playersMove[1]];
				}
				printField(playerField.getIntBoard());
			}
			else if(playersMove[2] == 1  && 9 == compField.getIntBoard()[playersMove[0]][playersMove[1]]){
				playerField.getIntBoard()[playersMove[0]][playersMove[1]] = 9;
				printField(playerField.getIntBoard());
				foundMines++;
			}
			else{
				playerField.getIntBoard()[playersMove[0]][playersMove[1]] = 9;
				printField(playerField.getIntBoard());
			}
		}

		if(dead){
			System.out.println("Game Over! You hit a mine!\nHere is the entire board");
			System.out.println("Player's Board");
			printField(playerField.getIntBoard());
			System.out.println("Unveiled Board");
			printField(compField.getIntBoard());
		}
		else{
			System.out.println("You've found all the mines!\nHere is the entire board");
			System.out.println("Player's Board");
			printField(playerField.getIntBoard());
			System.out.println("Unveiled Board");
			printField(compField.getIntBoard());
		}
	}

	//=============================================================================================

	/*
	 * 
	 * Methods
	 * 
	 */

	//Clears multiple squares when an empty square is found
	private static void clearEmpty(int r, int c, int[][] compBoard, int[][] playerBoard, boolean[][] checkBoard){

		for(int u = -1; u < 2; u++){
			for(int v = -1; v < 2; v++){
				if(0 == compBoard[r + u][c + v]){
					playerBoard[r + u][c + v] = compBoard[r + u][c + v];
					checkBoard[r][c] = true;
					if(!checkBoard[r + u][c + v]){
						clearEmpty(r + u, c + v, compBoard, playerBoard, checkBoard);
					}
				}
				else{
					playerBoard[r  + u][c + v] = compBoard[r + u][c + v];
				}
			}
		}
	}
	//Count the number of mines touching each square
	private static void findMines(int[][] board){
		int mineCounter = 0;

		for(int r = 1; r < board.length - 1; r++){
			for(int c = 1 ; c < board[r].length - 1; c++){
				mineCounter = 0;
				for(int u = -1; u < 2; u++){
					for(int v = -1; v < 2; v++){
						if(9 == board[r + u][c + v]){
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
	//Prompt Player for a move
	private static int[] playersMove(int[][] board){
		int hold;

		//Prompt user for coordinates and action
		System.out.println("Enter the coordinates of where you would like to go. A template has been provided.");
		System.out.println("Action List:\n0 = activate\n1 = flag");
		System.out.println("(1, 1, action)\nThis places the action at the bottom left corner");


		//Takes in the coordinates given by the player and separates everything based on the commas
		String playersMove = input.nextLine();
		String[] coordinates = playersMove.split(",");

		//Removes spaces and noninteger characters
		String column = coordinates[0].trim().replaceAll("[^0-9]", "");
		String row = coordinates[1].trim().replaceAll("[^0-9]", "");
		String action = coordinates[2].trim().replaceAll("[^0-9]", "");

		System.out.println("Coulmn: " + column);
		System.out.println("Row: " + row);
		System.out.println("Action: " + action);

		//Changes to an integer and puts it into an array to be returned
		int[] move = new int[3];
		move[0] = Integer.parseInt(column);
		move[1] = Integer.parseInt(row);
		move[2] = Integer.parseInt(action);

		//Puts players move into (row, column) order for computer field
		hold = move[0];
		move[0] = board.length - (move[1] + 1);
		move[1] = hold;

		return move;
	}
	
	//Prints out the passed integer field
	private static void printField(int[][] board){

		for(int r = 1; r < board.length - 1; r++){
			System.out.print("\n");
			for(int c = 1; c < board[0].length - 1; c++){
				System.out.printf("%-3d", board[r][c]);
			}
		}
		System.out.println("\n");
	}
	
	//Prints out the passed boolean field
	private static void printFieldBoolean(boolean[][] board){
		
		for(int r = 1; r < board.length - 1; r++){
			System.out.print("\n");
			for(int c = 1; c < board[0].length - 1; c++){
				System.out.print(board[r][c]);
			}
		}
		System.out.println("\n");
	}
}
