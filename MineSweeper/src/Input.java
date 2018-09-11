/*
 * Mark Johnson
 * CompSci 2 Section 1
 * Input Validation
 * December 17th 2017 
 */
import java.util.Scanner;

public class Input {
	private static Scanner reader = new Scanner(System.in);

	//read in any int
	public static int readInt(String prompt){
		int validity = -1, num = 0;

		while(validity == -1){
			System.out.println(prompt);
			if(reader.hasNextInt()){
				num = reader.nextInt();
				validity = 0;
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//--------------------------------------------------------------------------------------------------------------	
	//read in any double
	public static double readDouble(String prompt){
		int validity = -1;
		double num = 0;

		while(validity == -1){
			System.out.println(prompt);
			if(reader.hasNextDouble()){
				num = reader.nextDouble();
				validity = 0;
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//-----------------------------------------------------------------------------------------------------------
	//read in an int that is less than or equal to a specified maximum
	public static int readNum(String prompt, int max){
		int num = max + 1;

		while(num > max){
			System.out.println(prompt);
			if(reader.hasNextInt()){
				num = reader.nextInt();
				if (num > max){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//----------------------------------------------------------------------------------------------------------
	//read in an int that is greater than or equal to a specified minimum
	public static int readNum(int min, String prompt){
		int num = min - 1;

		while(num < min){
			System.out.println(prompt);
			if(reader.hasNextInt()){
				num = reader.nextInt();
				if (num < min){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//----------------------------------------------------------------------------------------------------------
	//read in an int that is within a given range, Inclusive
	//Ensure that the minimum is less then the maximum
	public static int readNum(String prompt, int min, int max){
		int num = max + 1;

		while(num < min || num > max){
			System.out.println(prompt);
			if(reader.hasNextInt()){
				num = reader.nextInt();
				if (num < min || num > max){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//----------------------------------------------------------------------------------------------------------
	//read in a double that is less than or equal to a specified maximum
	public static double readNum(String prompt, double max){
		double num = max + 1;

		while(num > max){
			System.out.println(prompt);
			if(reader.hasNextDouble()){
				num = reader.nextDouble();
				if (num > max){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//---------------------------------------------------------------------------------------------------------
	//read in a double that is greater than or equal to a specified minimum
	public static double readNum(double min, String prompt){
		double num = min - 1;

		while(num < min){
			System.out.println(prompt);
			if(reader.hasNextDouble()){
				num = reader.nextDouble();
				if (num < min){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//----------------------------------------------------------------------------------------------------------
	//read in a double that is within a given range, Inclusive
	//Ensure that the minimum is less than max
	public static double readNum(String prompt, double min, double max){
		double num = max + 1;

		while(num < min || num > max){
			System.out.println(prompt);
			if(reader.hasNextDouble()){
				num = reader.nextDouble();
				if (num < min || num > max){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	} 
	//----------------------------------------------------------------------------------------------------------
	//reads in an int and prompts the user for whether they want a max (true) or a minimum (false) limit and what the number limit is
	public static int readNum(String prompt, int limit, boolean minMax){
		int num = 0;

		if(minMax){
			num = limit + 1;

			while(num < limit){
				System.out.println(prompt);
				if(reader.hasNextInt()){
					num = reader.nextInt();
					if (num < limit){
						System.out.println("Invalid Entry");
					}
				}
				else{
					System.out.println("Invalid Entry");
				}
				reader.nextLine();
			}
		}
		else{
			num = limit - 1;
			while(num > limit){
				System.out.println(prompt);
				if(reader.hasNextInt()){
					num = reader.nextInt();
					if (num > limit){
						System.out.println("Invalid Entry");
					}
				}
				else{
					System.out.println("Invalid Entry");
				}
				reader.nextLine();
			}
		}
		return num;
	}
	//----------------------------------------------------------------------------------------------------------
	//reads in an double and prompts the user for whether they want a max (true) or a minimum (false) limit and what the number limit is
	public static double readNum(String prompt, double limit, boolean minMax){
		double num = 0;

		if(minMax){
			num = limit + 1;
			while(num < limit){
				System.out.println(prompt);
				if(reader.hasNextDouble()){
					num = reader.nextDouble();
					if (num < limit){
						System.out.println("Invalid Entry");
					}
				}
				else{
					System.out.println("Invalid Entry");
				}
				reader.nextLine();
			}
		}
		else{
			num = limit - 1;
			while(num > limit){
				System.out.println(prompt);
				if(reader.hasNextDouble()){
					num = reader.nextDouble();
					if (num > limit){
						System.out.println("Invalid Entry");
					}
				}
				else{
					System.out.println("Invalid Entry");
				}
				reader.nextLine();
			}
		}
		return num;
	}
	//Integer greater than specified minimum
	public static int readNumNoEqual(int min, String prompt){
		int num = min;

		while(num <= min){
			System.out.println(prompt);
			if(reader.hasNextInt()){
				num = reader.nextInt();
				if (num <= min){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//Double greater than specified minimum
	public static double readNumNoEqual(double min, String prompt){
		double num = min;

		while(num <= min){
			System.out.println(prompt);
			if(reader.hasNextDouble()){
				num = reader.nextDouble();
				if (num <= min){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//Integer less than specified maximum
	public static int readNumNoEqual(String prompt, int max){
		int num = max;

		while(num >= max){
			System.out.println(prompt);
			if(reader.hasNextInt()){
				num = reader.nextInt();
				if (num >= max){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	//Double less than specified maximum
	public static double readNumNoEqual(String prompt, double max){
		double num = max;

		while(num >= max){
			System.out.println(prompt);
			if(reader.hasNextDouble()){
				num = reader.nextDouble();
				if (num >= max){
					System.out.println("Invalid Entry");
				}
			}
			else{
				System.out.println("Invalid Entry");
			}
			reader.nextLine();
		}
		return num;
	}
	/*public static char readChar(String prompt){
		int validity = -1;
		char letter ='z';
	
		while(validity == -1){
			System.out.println(prompt);
			if (reader.has)
		}
	}*/
}