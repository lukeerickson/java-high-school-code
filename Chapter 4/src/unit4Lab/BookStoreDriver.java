package unit4Lab;

import java.util.Scanner;
import java.io.*;

//CODE COMMENTS

public class BookStoreDriver {
	
	private static final int END_SESSION = 0;
	private static final int PRINT_ALL = 1;
	private static final int SEARCH_TITLE = 2;
	private static final int SEARCH_AUTHOR = 3;
	private static final int PRINT_FOR_PURCHASE = 4;
	private static final int PRINT_NEW_RELEASES = 5;
	private static final int PURCHASE_BOOKS = 6;
	private static final int ADD_BOOKS = 7;
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		BookStore nicholsBookStore = new BookStore();
		nicholsBookStore.inputBook();
			
		boolean loop = true;
		while(loop) {
			int selected = getChoice();
			
			if(selected == END_SESSION) {
				printFarewell();
				loop = false;
			}
			if(selected == PRINT_ALL)
				nicholsBookStore.printLibrary();
			if(selected == SEARCH_TITLE)
				nicholsBookStore.searchByTitle();
			if(selected == SEARCH_AUTHOR)
				nicholsBookStore.searchByAuthor();
			if(selected == PRINT_FOR_PURCHASE)
				nicholsBookStore.printAvailableBooks();
			if(selected == PRINT_NEW_RELEASES)
				nicholsBookStore.printNewReleases();
			if(selected == PURCHASE_BOOKS)
				nicholsBookStore.purchase();
			if(selected == ADD_BOOKS)
				nicholsBookStore.addToInventory();
			else if(selected < 0 || selected > 7)
				System.out.println("Sorry, but you didn't enter a valid number selection. Please try again.\n");
			}
		
	}
	
	public static int getChoice() {
		
		//boolean loop = true;
		
		//System.out.println(loop);
		//while(loop) {
			System.out.println("*** Book Store Options ***");
			System.out.println("\t0. Enter 0 to end your session");
			System.out.println("\t1. View all books");
			System.out.println("\t2. Search by title");
			System.out.println("\t3. Search by author");
			System.out.println("\t4. View available books for purchase");
			System.out.println("\t5. View new releases");
			System.out.println("\t6. Purchase one or more copies of a book");
			System.out.println("\t7. Add book(s) to inventory");
			
			System.out.println("\nPlease enter your choice: ");
			
			// how do i do this as a loop?
			// i can do it as a decision but not as a loop
			// "getChoice () Must utilize a loop to confirm user enters a valid number
			
			Scanner kb = new Scanner(System.in);
			int choice = kb.nextInt();
			if(choice < 0 || choice > 7)
				choice = -1;
			return choice;
			
			//if(choice >= 0 && choice <= 7) {
				//loop = false;
			//}
			//else
				//System.out.println("Sorry, but you didn't enter a valid number selection. Please try again.");
			
			
		}
	
	public static void printFarewell() {
		System.out.println("Thank you for using our library system. Good bye!");
	}
		
		//kb.close();
	
	
}
