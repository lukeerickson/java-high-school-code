package ws5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadsAllDataTypes {

	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		Scanner inF = new Scanner(new File("allDataTypes.txt"));    
		
		while(inF.hasNextLine()) {
			String word = inF.nextLine();
			System.out.println(word);
		}
		
		while(inF.hasNextInt()) {
			int num = inF.nextInt();
			System.out.println(num);
		}
		
		while(inF.hasNextDouble()) {
			double decimal = inF.nextDouble();
			System.out.println(decimal);
		}
		
		while(inF.hasNextBoolean()) {
			boolean yes = inF.nextBoolean();
			System.out.println(yes);
		}
		
	}

}
