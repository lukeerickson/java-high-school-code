package inputOutput;
/**
 * Represents a Street Address
 * 
 * @author Mr. Nichols - from Textbook
 * @version 10-1-17
 */
public class Address
{
    private String streetAddress, city, state;
    private int zipCode;
    
    /**
     * Constructor for objects of class Address
     */
    public Address()
    {
    	streetAddress = "";
    	city = "";
    	state = "";
    	zipCode = 0;
    }
    
    public Address(String streetAddress, String city, String state, int zipCode)
    {
        this.streetAddress = streetAddress;
        this.city  = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * Returns the address as a nicely formatted String
     * 
     * @return     result - the address
     */
    public String toString()
    {
        String result = streetAddress + "\n";
        result += city + ", " + state + " " + zipCode;
        
        return result;
    }
    
    public void setAddress(String streetAddress, String city, String state, int zipCode)
    {
        this.streetAddress = streetAddress;
        this.city  = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
