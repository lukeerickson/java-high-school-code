package pets;

public class Dog extends Pet
{
	private int weight;
	
	public Dog(String name, int age, int weight)
	{
		super(name, age);
		this.weight = weight;
	}
	
	public String makeNoise()
	{
		return "Woof!";
	}
	
	public String move()
	{
		return "run";
	}
	
	public String toString()
	{
		String output = super.toString();
		output += " and weighs " + weight + " pounds";
		return output;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
}
