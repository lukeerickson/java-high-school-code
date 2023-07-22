package unit4Lab;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



public class BookStore {
	
	private ArrayList<Book> bookList;
	private Scanner kb;
	private Scanner inF;
	
	/**
	 * bookList constructor
	 * Description: creates the bookList ArrayList necessary to store the data from all of our book objects
	 */
	public BookStore() {
		bookList = new ArrayList<Book>();
	}
	
	/**
	 * @throws IOException
	 * @throws FileNotFoundException
	 * Description: Imports text file, loops through the file, creates Book objects, and adds them to bookList
	 */
	public void inputBook() throws IOException, FileNotFoundException {		
		inF = new Scanner(new File("bookList.txt"));
		String author, title;
		int publishYear, quantityInStock;
		
		// Loop through text file and create Book objects
		
        while(inF.hasNextLine())
        {   // Read in all parameters for the Book object
            author = inF.nextLine();
            title = inF.nextLine();           
            publishYear = inF.nextInt();
            // dummy read
            inF.nextLine();
            quantityInStock = inF.nextInt();
            // dummy read
            inF.nextLine();
               
            bookList.add(new Book(title, author, publishYear, quantityInStock));
            
        }
        
        inF.close();
		
	}
	
	/**
	 * Description: Uses a for-each loop that goes through each Book object in bookList and prints it using the toString() method written in the Book class
	 */
	public void printLibrary() {
		System.out.println("\t\t***** COMPLETE LIST OF LIBRARY BOOKS *****");
		for(Book novel: bookList)
			System.out.println(novel);
		System.out.println();
	}
	
	/**
	 * Description: Prompts user to enter the title of the book they are looking for.
	 * Uses a for-each loop to compare the title of each Book object in the bookList
	 * and print the book if the title matches what the user inputed.
	 * Displays appropriate message if the user inputed incorrect information.
	 */
	public void searchByTitle() {
		System.out.println("Please enter the desired book's title");
		Scanner kb = new Scanner(System.in);
		String desiredTitle = kb.nextLine();
		desiredTitle = desiredTitle.toLowerCase();
		
		System.out.println("\t\t***** RESULTS OF YOUR SEARCH BY TITLE *****");
		int booksPrinted = 0;
		for(Book novel: bookList) {
			if(novel.getTitle().toLowerCase().contains(desiredTitle)) {
				System.out.println(novel);
				booksPrinted++;
			}
		}	
		
		if(booksPrinted == 0)
			System.out.println("We couldn't find the book you were looking for. Please try again.");
		
		System.out.println();
		
	}
	
	/**
	 * Description: Prompts user to enter the author of the book they are looking for.
	 * Uses a for-each loop to compare the author of each Book object in the bookList
	 * and print the book if the author matches what the user inputed.
	 * Displays appropriate message if the user inputed incorrect information.
	 */
	public void searchByAuthor() {
		System.out.println("Please enter the desired author's name");
		Scanner kb = new Scanner(System.in);
		String desiredAuthor = kb.nextLine();
		desiredAuthor = desiredAuthor.toLowerCase();
		
		System.out.println("\t\t***** RESULTS OF YOUR SEARCH BY AUTHOR *****");
		int booksPrinted = 0;
		for(Book novel: bookList) {
			if(novel.getAuthor().toLowerCase().contains(desiredAuthor)) {
				System.out.println(novel);
				booksPrinted++;
			}
		}	
		
		if(booksPrinted == 0)
			System.out.println("We couldn't find the book you were looking for. Please try again.");
		
		System.out.println();
	}
	
	/**
	 * Description: Uses a for-each loop to print the Book objects in bookList that have more than one copy available
	 * Displays appropriate message if the user inputed incorrect information.
	 */
	public void printAvailableBooks() {
		System.out.println("\t\t***** BOOKS AVAILABLE FOR PURCHASE *****");
		int booksPrinted = 0;
		for(Book novel: bookList) {
			if(novel.getQuantityInStock() > 0) {
				System.out.println(novel);
				booksPrinted++;
			}
		}	
		
		if(booksPrinted == 0){
			System.out.println("We couldn't find any book in this category. Please try again.");
		}
		System.out.println();
	}
	
	/**
	 * Description: Uses a for-each loop to print the Book objects in bookList that are new releases
	 * Displays appropriate message if the user inputed incorrect information.
	 */
	public void printNewReleases() {
		System.out.println("\t\t***** NEW RELEASES *****");
		int booksPrinted = 0;
		for(Book novel: bookList) {
			if(novel.isNewRelease()) {
				System.out.println(novel);
				booksPrinted++;
			}
		}	
		
		if(booksPrinted == 0)
			System.out.println("We couldn't find any book in this category. Please try again.");
		
		System.out.println();
	}
	
	/**
	 * Description: Prompts user for product number of desired book and quantity they are looking for.
	 * Uses a for loop to check through each book and find the book they are looking for based on the inputed product number.
	 * Updates the copies the library has available, and prints a message telling the user they have successfully purchased their book(s).
	 * Displays appropriate message if the user inputed incorrect information.
	 */
	public void purchase() {
		System.out.println("Which book would you like to purchase?\nEnter Product Number");
		Scanner kb = new Scanner(System.in);
		String desiredProductCode = kb.nextLine();
		int booksFound = 0;
		for(Book novel: bookList) {
			if(novel.getProductCode().toLowerCase().equals(desiredProductCode.toLowerCase())) {
				booksFound++;
				System.out.println("How many copies would you like?\nQuantity: ");
				int quantityForPurchase = kb.nextInt();
				kb.nextLine();
				if(quantityForPurchase < 0) {
					System.out.println("Please enter a valid quantity for purchase.");
					purchase();
				}
				if(quantityForPurchase > novel.getQuantityInStock()) {
					System.out.println("I'm sorry but there are not that many copies available. There are only " + novel.getQuantityInStock() + " available. Please try again.");
					purchase();
				}
				else {
					int newQuantityInStock = novel.getQuantityInStock() - quantityForPurchase;
					novel.setQuantityInStock(newQuantityInStock);
					System.out.println("You have successfully purchased " + quantityForPurchase + " copies of " + novel.getTitle() + ".");
				}		
			}
		}
			
		if(booksFound == 0) {
			System.out.println("The product number you entered was invalid. Please try again.");
			purchase();
		}
	}
	
	
	
	/**
	 * Description: Prompts user for product number of desired book and quantity they are looking for.
	 * Uses a for loop to check through each book and find the book they are looking for based on the inputed product number.
	 * Updates the copies the library has available, and prints a message telling the user they have successfully added the given book(s) to the library inventory.
	 * Displays appropriate message if the user inputed incorrect information.
	 */
	public void addToInventory() {
		System.out.println("Which book would you like to add to the library inventory?\nEnter Product Number");
		Scanner kb = new Scanner(System.in);
		String desiredProductCode = kb.nextLine();
		int booksFound = 0;
		for(Book novel: bookList) {
			if(novel.getProductCode().toLowerCase().equals(desiredProductCode.toLowerCase())) {
				booksFound++;
				System.out.println("How many copies would you like to add?\nQuantity: ");
				int quantityAdded = kb.nextInt();
				kb.nextLine();
				if(quantityAdded < 0) {
					System.out.println("Please enter a valid quantity to add to the inventory.");
					purchase();
				}
				else {
					int newQuantityInStock = novel.getQuantityInStock() + quantityAdded;
					novel.setQuantityInStock(newQuantityInStock);
					System.out.println("You have successfully added " + quantityAdded + " copies of " + novel.getTitle() + " to the inventory.");
				}		
			}
		}
		
		if(booksFound == 0) {
			System.out.println("The product number you entered was invalid. Please try again.");
			purchase();
		}
	}


	/**
	 * @return bookList
	 */
	public ArrayList<Book> getBookList() {
		return bookList;
	}


	/**
	 * @param bookList
	 */
	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}


	/**
	 * @return kb
	 */
	public Scanner getKb() {
		return kb;
	}


	/**
	 * @param kb
	 */
	public void setKb(Scanner kb) {
		this.kb = kb;
	}


	/**
	 * @return inF
	 */
	public Scanner getInF() {
		return inF;
	}


	/**
	 * @param inF
	 */
	public void setInF(Scanner inF) {
		this.inF = inF;
	}
	
}
