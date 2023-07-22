package tacoTruck;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Luke Erickson
 * October 18 2019
 * Period 7
 * Mr. Nichols
 * 
 * Description: The program prompts the user for how they would like to design their taco, 
 * records this information, uses this info to calculate the price of their order, 
 * and then prints a receipt of their order
 */

public class Taco {

	// instance variables
	private int quantity;
	private String fillingType, shellType;
	
	private static final int chicken = 1;
	private static final int beef = 2;
	private static final int vegetarian = 3;
	private static final int softShell = 1;
	private static final int hardShell = 2;
	
	private double individualPrice, completeTacoPrice, totalPrice, discount, discountedPrice;
	
	private boolean wantsCheese, wantsSourCream, wantsGuac, isTacoTuesday;
	private final double tacoTuesdayDiscount = 0.75;
	private final double meatPrice = 2.00;
	private final double vegetarianPrice = 1.50;
	private final double cheesePrice = 0.50;
	private final double sourCreamPrice = 0.50;
	private final double guacPrice = 0.50;
	private static Scanner kb;
	private static Random rand;
	
	// static makes variable global
	
	/**
	 * Description: prompts user as to how they would like to design their taco, and creates a taco object given this input
	 * @return taco object
	 */
	public Taco() 
	{
		
		checkIfTuesday();
		askQuantity();		
		askTypeOfFilling();		
		askForCheese();		
		askForSourCream();		
		askForGuac();		
		askShellType();
				
		System.out.println("");
		
	}
	
	/**
	 *  Description: generates random number between 1 and 7. If day 1 and thereby Tuesday, the user gets a 25% discount
	 */
	public void checkIfTuesday() {
		
		rand = new Random();
		int rand7 = 1 + rand.nextInt(7);
		if(rand7 == 1) {
			System.out.println("Congrats! It's Taco Tuesday! 25% off of all tacos today");
			isTacoTuesday = true;
		}
	}
	
	/**
	 * Description: Prompt user for how many tacos they would like and record in quantity private variable
	 */
	public void askQuantity() {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("How many tacos would you like?");
		quantity = kb.nextInt();
	}
	
	/**
	 * Description: Prompt user for their filling and compare entries to fillings to set filling variable, re-prompt if bad answer is given
	 */
	public void askTypeOfFilling() {
		
		System.out.println("What type of filling would you like? \n   1. Chicken \n   2. Beef \n   3. Vegetarian \n");
		System.out.println("Please enter 1, 2, or 3");
		
		boolean loop = true;
		
		while(loop)
		{
			loop = false;
			Scanner kb = new Scanner(System.in);
			int choice = kb.nextInt();
			if(choice == chicken)
				setFillingType("Chicken");
			if(choice == beef)
				setFillingType("Beef");
			if(choice == vegetarian)
				setFillingType("Vegetarian");
			else if(choice < chicken || choice > vegetarian)
			{
				System.out.println("Please enter 1, 2, or 3");
				loop = true;
			}
		}	
	}
	
	/**
	 * Description: Prompt user if they would like cheese and set boolean variable accordingly, re-prompt if bad answer is given
	 */
	public void askForCheese() {
		
		Scanner kb = new Scanner(System.in);
		//String dummyVariable = kb.nextLine();
		
		System.out.println("Would you like cheese? (Y/N)");
		
		boolean loop = true;
		while(loop)
		{
			loop = false;
			
			String str = kb.nextLine();
			if(str.equals("y") || str.equals("Y")) 
				setWantsCheese(true);
			else if(str.equals("n") || str.equals("N"))
				setWantsCheese(false);
			else
			{
				System.out.println("Would you like cheese? (Y/N)");
				loop = true;
			}
		}
		
	}

	/**
	 * Description: Prompt user if they would like cheese and set boolean variable accordingly, re-prompt if bad answer is given
	 */
	public void askForSourCream() {
		
		System.out.println("Would you like sour cream? (Y/N)");
		
		boolean loop = true;
		while(loop)
		{
			loop = false;
			Scanner kb = new Scanner(System.in);
			String str = kb.nextLine();
			if(str.equals("y") || str.equals("Y")) 
				setWantsSourCream(true);
			else if(str.equals("n") || str.equals("N"))
				setWantsSourCream(false);
			else
			{
				System.out.println("Would you like sour cream? (Y/N)");
				loop = true;
			}
		}
	}
	
	/**
	 * Description: Prompt user if they would like guac and set boolean variable accordingly, re-prompt if bad answer is given
	 */
	public void askForGuac() {
		
		System.out.println("Would you like guac? (Y/N)");
		
		boolean loop = true;
		while(loop)
		{
			loop = false;
			Scanner kb = new Scanner(System.in);
			String str = kb.nextLine();
			if(str.equals("y") || str.equals("Y")) 
				setWantsGuac(true);
			else if(str.equals("n") || str.equals("N"))
				setWantsGuac(false);
			else
			{
				System.out.println("Would you like guac? (Y/N)");
				loop = true;
			}
		}
	}
	
	/**
	 * Description: Prompt user for their shell type and compare entries to shell type to set shellType variable, re-prompt if bad answer is given
	 */
	public void askShellType() {
		
		System.out.println("What type of shell would you like? \n   1. Soft \n   2. Hard \n");
		System.out.println("Please enter 1 or 2");
		
		boolean loop = true;
		while(loop)
		{
			loop = false;
			Scanner kb = new Scanner(System.in);
			int choice = kb.nextInt();
			if(choice == softShell)
				setShellType("Soft");
			if(choice == hardShell)
				setShellType("Hard");
			else if(choice < softShell || choice > hardShell)
			{
				System.out.println("Please enter 1 or 2");
				loop = true;
			}
		}	
	}
	
	
	/**
	 * Description: initialize prices of different parts of a taco, including price of an individual taco, price of all tacos, and price of all tacos after the taco tuesday discount
	 */

	public void takeOrder() 
	{
		if(getFillingType() == "Chicken" || getFillingType() == "Beef")
			setIndividualPrice(getMeatPrice());
		else
			setIndividualPrice(getVegetarianPrice());
		
		double newPrice = getIndividualPrice();
	
		if(isWantsCheese() == true)
			newPrice += getCheesePrice();
		if(isWantsSourCream() == true)
			newPrice += getCheesePrice();
		if(isWantsGuac() == true)
			newPrice += getGuacPrice();		
		
		setCompleteTacoPrice(newPrice);
		
		setTotalPrice(getCompleteTacoPrice() * getQuantity());
		setDiscountedPrice(getTotalPrice() * getTacoTuesdayDiscount());
		setDiscount(getTotalPrice() - getDiscountedPrice());
		
	}
	
	/**
	 * Description: prints of receipt of the users order given how much they paid for each item as calculated in the takeOrder() function
	 */

	public void printTacoOrder()
	{
		DecimalFormat money = new DecimalFormat("$###,###.00");
         
         System.out.println("**********************************************************");
         System.out.println("************* Thank you for your taco order! *************");
         System.out.println("**********************************************************");
         
         if(isTacoTuesday == true)
        	 System.out.println(" Congrats its Taco Tuesday! 25% off of your entire order! ");
         
         System.out.println("");
         
         System.out.println(getQuantity() + " tacos ordered\n");
         
         System.out.println(getShellType() + " shell " + getFillingType() + " Taco\t\t" + money.format(getIndividualPrice()));
         System.out.println("Toppings:");
         if(wantsCheese == true)
         	System.out.println("\t\tCheese\t\t" + money.format(getCheesePrice())); 
         if(wantsSourCream == true)
        	 System.out.println("\t\tSour Cream\t" + money.format(getSourCreamPrice())); 
         if(wantsGuac == true)
        	 System.out.println("\t\tGuac\t\t" + money.format(getGuacPrice())); 
         
         System.out.println("");
         
         System.out.println("Total cost per taco is:\t\t" + money.format(getCompleteTacoPrice())); 
         System.out.println("Total cost of the order is:\t" + money.format(getTotalPrice()));
         
         if(isTacoTuesday == true) {
        	 System.out.println("Taco Tuesday Discount! You save " + money.format(getDiscount()) + "\n");
        	 System.out.println("Discounted cost is:\t\t" + money.format(getDiscountedPrice()));
         }
         
	}
	
	/**
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return
	 */
	public String getFillingType() {
		return fillingType;
	}

	/**
	 * @param fillingType
	 */
	public void setFillingType(String fillingType) {
		this.fillingType = fillingType;
	}

	/**
	 * @return
	 */
	public String getShellType() {
		return shellType;
	}

	/**
	 * @param shellType
	 */
	public void setShellType(String shellType) {
		this.shellType = shellType;
	}

	/**
	 * @return
	 */
	public double getIndividualPrice() {
		return individualPrice;
	}

	/**
	 * @param individualPrice
	 */
	public void setIndividualPrice(double individualPrice) {
		this.individualPrice = individualPrice;
	}

	/**
	 * @return
	 */
	public double getCompleteTacoPrice() {
		return completeTacoPrice;
	}

	/**
	 * @param completeTacoPrice
	 */
	public void setCompleteTacoPrice(double completeTacoPrice) {
		this.completeTacoPrice = completeTacoPrice;
	}

	/**
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * @return
	 */
	public double getDiscountedPrice() {
		return discountedPrice;
	}

	/**
	 * @param discountedPrice
	 */
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public boolean isWantsCheese() {
		return wantsCheese;
	}

	/**
	 * @param wantsCheese
	 */
	public void setWantsCheese(boolean wantsCheese) {
		this.wantsCheese = wantsCheese;
	}

	public boolean isWantsSourCream() {
		return wantsSourCream;
	}

	/**
	 * @param wantsSourCream
	 */
	public void setWantsSourCream(boolean wantsSourCream) {
		this.wantsSourCream = wantsSourCream;
	}

	public boolean isWantsGuac() {
		return wantsGuac;
	}

	/**
	 * @param wantsGuac
	 */
	public void setWantsGuac(boolean wantsGuac) {
		this.wantsGuac = wantsGuac;
	}

	public boolean isTacoTuesday() {
		return isTacoTuesday;
	}

	/**
	 * @param isTacoTuesday
	 */
	public void setTacoTuesday(boolean isTacoTuesday) {
		this.isTacoTuesday = isTacoTuesday;
	}

	/**
	 * @return
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
	 * @return
	 */
	public Random getRand() {
		return rand;
	}

	/**
	 * @param rand
	 */
	public void setRand(Random rand) {
		this.rand = rand;
	}

	/**
	 * @return
	 */
	public static int getChicken() {
		return chicken;
	}

	/**
	 * @return
	 */
	public static int getBeef() {
		return beef;
	}

	/**
	 * @return
	 */
	public static int getVegetarian() {
		return vegetarian;
	}

	/**
	 * @return
	 */
	public static int getSoftshell() {
		return softShell;
	}

	/**
	 * @return
	 */
	public static int getHardshell() {
		return hardShell;
	}

	/**
	 * @return
	 */
	public double getTacoTuesdayDiscount() {
		return tacoTuesdayDiscount;
	}

	/**
	 * @return
	 */
	public double getMeatPrice() {
		return meatPrice;
	}

	/**
	 * @return
	 */
	public double getVegetarianPrice() {
		return vegetarianPrice;
	}

	/**
	 * @return
	 */
	public double getCheesePrice() {
		return cheesePrice;
	}

	/**
	 * @return
	 */
	public double getSourCreamPrice() {
		return sourCreamPrice;
	}

	/**
	 * @return
	 */
	public double getGuacPrice() {
		return guacPrice;
	}
	
}
