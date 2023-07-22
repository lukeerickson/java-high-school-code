package inputOutput;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InOutPractice {
	
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		Scanner inF = new Scanner(new File("Haiku.txt"));    
		 PrintWriter outF = new PrintWriter(new FileWriter("SingleLineHaiku.txt"));
		
		while(inF.hasNextLine())
		{
			String word = inF.next();
			outF.println(word);
		}
		
		outF.close();
		System.out.println("Your file has been successfully completed");
		
	}

}
