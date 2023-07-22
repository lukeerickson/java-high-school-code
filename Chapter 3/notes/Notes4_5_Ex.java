package notes;
/**
 * This program demonstrates the difference between pass by value and pass by reference
 * 
 * @author Mrs. Denna
 * @version 9-27-16
 */
public class Notes4_5_Ex
{
    public static void main(String[] args)
    {
    
        // Create basic int, String, Address, and BankAccount variables
        String name = "Mr. Nichols";
        int favNum = 47;
        // Address home = new Address("1000 S. Quentin  Rd.", "Palatine", "IL", 60067);
        // BankAccount acct1 = new BankAccount(500, 12345, "Savings", "Pass123", home);
    
        //Print initial values of these variables
        System.out.println("My name is: " + name + " and my favorite number is: " + favNum);
        // System.out.println(home);
        // System.out.println(acct1 + "\n\n");
    
        //Call methods to try to change the variable from the calling program
        changeNum(favNum);
        name = changeName(name);
        // changeAddress(home);
        // changeBankAcct(acct1);
        
        //Print values after method calls to see which ones (if any) have been changed    
        System.out.println("My name is: " + name + " and my favorite number is: " + favNum);
        // System.out.println(home);      
        // System.out.println(acct1);
    }
        
    public static void changeNum(int num)
    {
        num = 25;
    }
    
    public static String changeName(String str)
    {
        return ( "Awesome " + str);
    }
    
}
