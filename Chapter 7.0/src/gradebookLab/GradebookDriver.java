package gradebookLab;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * Author:	Luke Erickson
 * Teacher: Mr. Nichols
 * Period:	7th
 * 
 * Description: Main method - prompts user questions and scans responses to be fed to other classes
 * 				
 */

public class GradebookDriver {
	
	private static final int PERIOD_1 = 1;
	private static final int PERIOD_2 = 2;
	private static final int PERIOD_3 = 3;
	private static final int PERIOD_7 = 4;
	private static final int PERIOD_8 = 5;
	
	private static final int NAME_SORT = 1;
	private static final int SCORE_SORT = 2;
	private static final int SEARCH = 3;
	private static final int QUIT = 4;
	
	private static final int A_Z = 1;
	private static final int Z_A = 2;
	
	private static final int HI_LO = 1;
	private static final int LO_HI = 2;
	
	private static int period_choice = 0;
	private static int advanced_choice = 0;
	private static int final_choice = 0;
	
	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		Teacher micky = new Teacher("micky", 27, "math");
		
		micky.fillGradebook();
		//System.out.println(micky.toString());
		
		System.out.println("********************************************");
		System.out.println("*** Welcome to Fremd's Grade Book System ***");
		System.out.println("********************************************");
		
		boolean loop = true;
		while(loop) {
		
		// find class period
		getPeriodChoice();
		
		int period = 0;
		
		//update to match index in gradebooks[] array
		if(period_choice == PERIOD_1)
			period = 0;
		if(period_choice == PERIOD_2)
			period = 1;
		if(period_choice == PERIOD_3)
			period = 2;
		if(period_choice == PERIOD_7)
			period = 3;
		if(period_choice == PERIOD_8)
			period = 4;
		
		// find which feature of the program will be used
		getAdvancedChoice();
		
		if(advanced_choice == NAME_SORT) {
			
			// find if user will sort alphabetically or reverse alphabetically
			getNameSortChoice();
			
			if(final_choice == A_Z) {
				micky.getGradebooks()[period].sortLastNameAZ();
			}
			if(final_choice == Z_A) {
				micky.getGradebooks()[period].sortLastNameZA();
			}
			System.out.println(micky.getGradebooks()[period].toString());	
		}
		
		if(advanced_choice == SCORE_SORT) {
			
			// find if user will sort low to high or high to low
			getSearchSortChoice();
			
			if(final_choice == HI_LO) {
				micky.getGradebooks()[period].sortAvgHighLow();
			}
			if(final_choice == LO_HI) {
				micky.getGradebooks()[period].sortAvgHighLow();
			}
			System.out.println(micky.getGradebooks()[period].toString());	
		}
		
		// prompt user to enter last name of student they are searching for
		if(advanced_choice == SEARCH) {
			System.out.println("\nPlease enter the last name you are searching for\n");
			Scanner kb = new Scanner(System.in);
			String str = kb.nextLine();
			System.out.println(micky.getGradebooks()[period].search(str));
		}
		
		// end loop and end program
		if(advanced_choice == QUIT) {
			printFarewell();
			loop = false;
		}
			
	}
	}
	
	
	/**
	 * Prompt user for which period they would like to work with
	 */
	public static void getPeriodChoice() {
		
		System.out.println("\nPlease select the desired class period:");
		
		boolean loop = true;
		while(loop) {
			System.out.println("1. Period 1");
			System.out.println("2. Period 2");
			System.out.println("3. Period 3");
			System.out.println("4. Period 7");
			System.out.println("5. Period 8\n");
			Scanner kb = new Scanner(System.in);
			try {
				period_choice = kb.nextInt();
				if(period_choice > 0 && period_choice < 6)
					loop = false;
				else {
					loop = true;
					System.out.println("\nPlease enter a valid number");
				}
			}
			catch(Exception e) {
				System.out.println("\nPlease enter a valid number");
			}
		}
	}
	
	/**
	 * Prompt user for which feature of the program they would like to use
	 */
	public static void getAdvancedChoice() {
		System.out.println("\nPlease select from the choices below:");
		
		boolean loop = true;
		while(loop) {
			System.out.println("1. Sort students by name");
			System.out.println("2. Sort students by average score");
			System.out.println("3. Search for a student");
			System.out.println("4. Quit grade book\n");
			Scanner kb = new Scanner(System.in);
			try {
				advanced_choice = kb.nextInt();
				if(advanced_choice > 0 && advanced_choice < 5)
					loop = false;
				else {
					loop = true;
					System.out.println("\nPlease enter a valid number");
				}
			}
			catch(Exception e) {
				System.out.println("\nPlease enter a valid number");
			}
		}
	}	
		
	/**
	 * Prompt user for how they would like to search by name
	 */
	public static void getNameSortChoice() {
		System.out.println("\nPlease select from the choices below:");
		
		boolean loop = true;
		while(loop) {
			System.out.println("1. A-Z");
			System.out.println("2. Z-A\n");
			Scanner kb = new Scanner(System.in);
			try {
				final_choice = kb.nextInt();
				if(final_choice > 0 && final_choice < 3)
					loop = false;
				else {
					loop = true;
					System.out.println("\nPlease enter a valid number");
				}
			}
			catch(Exception e) {
				System.out.println("\nPlease enter a valid number");
			}
		}
	}
	
	/**
	 * Prompt user for how they would like to search by test score
	 */
	public static void getSearchSortChoice() {
		System.out.println("\nPlease select from the choices below:");
		
		boolean loop = true;
		while(loop) {
			System.out.println("1. Highest average to lowest average");
			System.out.println("2. Lowest average to highest average");
			Scanner kb = new Scanner(System.in);
			try {
				final_choice = kb.nextInt();
				if(final_choice > 0 && final_choice < 3)
					loop = false;
				else {
					loop = true;
					System.out.println("\nPlease enter a valid number");
				}
			}
			catch(Exception e) {
				System.out.println("\nPlease enter a valid number");
			}
		}
	}
		
	/**
	 * say goodbye!
	 */
	public static void printFarewell() {
		System.out.println("\nThank you for using our system. See ya!");
	}
	
}
