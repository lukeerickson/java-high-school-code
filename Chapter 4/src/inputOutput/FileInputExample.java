package inputOutput;
import java.util.Scanner;
import java.io.*;

/**
 * This is an example of how to read in text files and store data into variables
 * 
 * @author  Mrs. Denna
 * @version 9-27-16
 */
public class FileInputExample
{
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        Person[] database = new Person[3];      // declaring an array to hold the incoming Person data
    
        // if file is in the same folder as .java code all you need is the file name
        Scanner inF = new Scanner(new File("AddressData.txt"));       // opens the file stream for input reading
        String name, street, city, state;
        int zip;
        int i = 0;
        
        while(inF.hasNextLine())
        {                                   // Read in all parameters for the Address object
            name = inF.nextLine();
            street = inF.nextLine();
            city = inF.nextLine();
            state = inF.nextLine();
            zip = inF.nextInt();           // create the new Address object and pass it as a parameter to 
            if (inF.hasNextLine())
            	inF.nextLine();                                // the Person constructor
            
            database[i] = new Person(name, new Address(street, city, state, zip));
            i++;
        }
        inF.close();
        
        for (int j = 0; j < database.length; j++)
            System.out.print(database[j] + "\n\n");
    }
    
}
