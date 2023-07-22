package cellPhone;

import java.util.Scanner;
/**
 * Write a description of class CellPhoneDriver here.
 * 
 * @author Mr. Nichols 
 * @version 9-25-16
 */
public class CellPhoneDriver
{
    public static void main(String[] args)    
    {
        System.out.println("\f");
        CellPhone firstPhone = new CellPhone();
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("How many full minutes did you use?");
        int minUsed = in.nextInt();
        System.out.println("How many gigabites of data did you use?");
        double gigsUsed = in.nextDouble();
        
        firstPhone.calculateOverageCharge(minUsed, gigsUsed);
    }
}
