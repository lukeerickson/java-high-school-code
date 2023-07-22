package inputOutput;
import java.util.Scanner;
import java.io.*;

/**
 * This program will demonstrate how to write output to a textfile
 * 
 * @author  Mrs. Denna 
 * @version 9-27-16
 */
public class FileOutputExample  
{
    public static void main(String[] args)  throws IOException, FileNotFoundException
    {        
       
        /* outF is the output stream that is printing to a file called myOutput.txt
         * instead of doing System.out.println we can just do outF.println
         * this will now print the info into the text file versus on the screen* 
         */
        
        PrintWriter outF = new PrintWriter(new FileWriter("myOutput.txt"));
        
        // Create and fill an array with multiples of 3
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++)
            nums[i] = i*3;
        
        // Print array values to the textfile    
        outF.println("This is my output for my array values: ");
        for (int j = 0; j < nums.length; j++)
            outF.println(nums[j]);
            
        // close file stream    
        outF.close();    
    }
}
