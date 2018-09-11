import java.util.Scanner;

public class testCoordinateInput {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Prompt user for coordinates and action
		System.out.println("Enter the coordinates of where you would like to go. A template has been provided.");
		System.out.println("(x, y, action)");
		
		
		//Takes in the coordinates given by the player and separates everything based on the commas
		String playersMove = input.nextLine();
		String[] coordinates = playersMove.split(",");
		
		String column = coordinates[0].trim().replaceAll("[^0-9]", "");
		String row = coordinates[1].trim().replaceAll("[^0-9]", "");
		String action = coordinates[2].trim().replaceAll("[^0-9]", "");
		
		System.out.println("coulmn: " + column);
		System.out.println("row: " + row);
		System.out.println("action: " + action);
	}

}
