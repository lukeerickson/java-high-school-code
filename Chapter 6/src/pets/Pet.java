package pets;

public abstract class Pet 
{
	private String name;
	private int age;


	public Pet(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String toString()
	{
		String output = name;
		output += " is " + age + " years old";
		return output;
	}

	public abstract String makeNoise(); // Returns String relative to the animals' sound
	
	public abstract String move(); // Returns String relative to the animals' movement
	
	public int getAge()
	{
		return age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
}
