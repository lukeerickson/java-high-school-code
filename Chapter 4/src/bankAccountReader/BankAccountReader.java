package bankAccountReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import bankAccountReader.BankAccount;

public class BankAccountReader {
	 public static void main(String[] args) throws IOException, FileNotFoundException
	    {
	        BankAccount[] database = new BankAccount[10];      // declaring an array to hold the incoming Person data
	    
	        // if file is in the same folder as .java code all you need is the file name
	        Scanner inF = new Scanner(new File("BankAccountData.txt"));       // opens the file stream for input reading
	        String name, bankName;
	        int pinNum;
	        double balance;
	        int i = 0;
	       
	        while(inF.hasNextLine())
	        {                                   // Read in all parameters for the BankAccount object
	            if(inF.hasNextLine()) {
	            	name = inF.nextLine();
	            	System.out.println(name);
	            	bankName = inF.nextLine();
	            	System.out.println(bankName);
	            }
	            	
	            else {
	            	name = "cheese";
	            	bankName = "op";
	            }
	            	
	            //if(inF.hasNextLine())
	            	//bankName = inF.nextLine();
	            //else
	            	//bankName = "op";
	            if(inF.hasNextInt()) {
	            	pinNum = inF.nextInt();
	            	//System.out.println(pinNum);
	            }
	            else
	            	pinNum = 0;
	            if(inF.hasNextDouble()) {
	            	balance = inF.nextDouble();  
	            	//System.out.println(balance);
	            }
	            	
	            else
	            	balance = 69.69;
	          
	            database[i] = new BankAccount(name, bankName, pinNum, balance);
	            i++;
	        }
	        
	        inF.close();
	        
	        //for (int j = 0; j < database.length; j++)
	            //System.out.print(database[j] + "\n\n");
	        
	    }
}
