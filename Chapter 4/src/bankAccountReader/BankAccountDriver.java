package bankAccountReader;

import java.util.Scanner;

public class BankAccountDriver 
{
	public static void main(String[] args)
	{
		
		BankAccount savings1 = new BankAccount();
		BankAccount savings2 = new BankAccount("Luke", "Hank", 5000,1234);
		
		savings2.transfer(savings1, 5);
		
		System.out.println(savings1);
		System.out.println(savings2);
		
	}
		

	
	private static BankAccount getInfo(Scanner kb)
	{
		
		System.out.println("\nPlease enter your full name:");
		String name = kb.nextLine();
		System.out.println("Please enter your bank's name:");
		String bankName = kb.nextLine();
		System.out.println("Please enter your preferred pin number:");
		int pin = kb.nextInt();
		System.out.println("Please enter your starting balance:");
		double startingBalance = kb.nextDouble();
		BankAccount randAccount = new BankAccount(name, bankName, pin, startingBalance);
		return randAccount;
	}
}
