package pets;

public class Pets 
{
	public static void main(String[] args)
	{
		// Build a Dog object
		Dog Bart = new Dog("Bart", 7, 100);
		// Build a Snake object
		Snake Clarissa = new Snake("Clarissa", 12, 12);
		
		// Print information for Dog
		System.out.println(Bart);
		// Print a sentence using the Dog's name and its noise
		System.out.println(Bart.getName() + " makes a " + Bart.makeNoise() + " noise");
		// Print a sentence using the Dog's weight and its movement
		System.out.println(Bart.getName() + " weighs " + Bart.getWeight() + " pound and loves to " + Bart.move());
		
		// Print information for Snake
		System.out.println(Clarissa);
		// Print a sentence using the Snake's name and its noise
		System.out.println(Clarissa.getName() + " makes a " + Clarissa.makeNoise() + " noise");
		// Print a sentence using the Snake's length and its movement		
		System.out.println(Clarissa.getName() + " is " + Clarissa.getLength() + " feet long and loves to " + Clarissa.move());

	}
}
