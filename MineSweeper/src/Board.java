
public class Board {
	private int[][] intBoard;
	private boolean[][] bolBoard;
	private int rows;
	private int columns;
	
	//Board Constructors
	
	//Integer board
	public Board(int r, int c, int random){
			
		intBoard = new int[r][c];
		rows = r;
		columns = c;
	}
	
	public Board(int r, int c, boolean random){
		
		bolBoard = new boolean[r][c];
		rows = r;
		columns = c;
	}

	//Getters and setters
	public int[][] getIntBoard() {
		return intBoard;
	}

	public void setIntBoard(int[][] intBoard) {
		this.intBoard = intBoard;
	}
	
	public boolean[][] getBolBoard() {
		return bolBoard;
	}

	public void setBolBoard(boolean[][] bolBoard) {
		this.bolBoard = bolBoard;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
}
