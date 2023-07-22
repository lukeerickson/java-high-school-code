package pets;

public class Snake extends Pet
{
	private int length;
	
	public Snake(String name, int age, int length)
	{
		super(name, age);
		this.length = length;
	}
	
	public String makeNoise()
	{
		return "Hisssss";
	}
	
	public String move()
	{
		return "Slither";
	}
	
	public String toString()
	{
		String output = super.toString();
		output += " and " + length + " feet long";
		return output;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public int getLength()
	{
		return length;
	}
}
