package ws3;

/**
 * This code determines if a user provided String 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WS2_Palindrome
{
    public static void main(String args[])
    {
        String[] phrases = {"Radar", "Racecars", "Never odd or even", "A Toyota! Race fast safe car: a Toyota", 
                            "Dessert ma! I am stressed!"};
        boolean result;    
        
        System.out.println("WS2 - Recursive Palindrome Checker");
        for (int i = 0; i < phrases.length; i++)
        {
            System.out.print(phrases[i]);
            result = isPalindrome(phrases[i]);
            if (result)
                System.out.print(" is a palindrome\n");
            else
                System.out.print(" is not a palindrome\n");
        }
    }
    
    
    /** Write a recursive method to test if a string is a Palindrome and returns a boolean true/false
     * @param str
     * @return if string is a palindrome
     */
    public static boolean isPalindrome(String str)
    {
        str = str.toLowerCase();
    	int i = 0;
    	int j = str.length()-1;
    	//runs normally if the first and last index are both characters
    	if(Character.isLetter(str.charAt(i)) && Character.isLetter(str.charAt(j))) {
    		//returns true if there is only one index remaining
    		if(str.length() == 1)
    			return true;
    		//returns true if there are two indexes remaining and they are the same
    		else if (str.length() == 2 && str.charAt(i) == str.charAt(j))
    			return true;
    		//returns false if the first and last index are different
    		else if(str.charAt(i) != str.charAt(j))
    			return false;    		
    		//runs the method again if the first and last index are equal
    		else
    			return isPalindrome(str.substring(i+1,j));
    	}
    	//removes last element if first element is a char
    	else if (Character.isLetter(str.charAt(i)))
    		return isPalindrome(str.substring(i,j));
    	//removes first element if last element is a char
    	else if (Character.isLetter(str.charAt(j)))
    		return isPalindrome(str.substring(i+1,j+1));
    	//removes first and last elements
    	else
    		return isPalindrome(str.substring(i+1,j));
    }
}
