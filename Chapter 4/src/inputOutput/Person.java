package inputOutput;
/**
 * Write a description of class Student here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String name;
    private Address home;

    /**
     * Constructor for objects of class Student
     */
    public Person(String name, Address home)
    {
        this.name = name;
        this.home = home;
    }

    /**
     * Prints the state of the Person object
     * 
     * @return     String representation of Person 
     */
    public String toString()
    {
        return (name + "\n" + home.toString());
    }
}
