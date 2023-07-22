package pokemonProject;

import java.util.Random;

public class Fire3 extends FireType {
	private static Random rand;
	private static final int ACCURACY = 90;
	
	public Fire3(String name, String cry, int attack) {
		super(name, cry, attack);
	}
	
	public String Attack(Pokemon pokemon) {
		rand = new Random();
		// generates hit percentage
		int randNum = rand.nextInt(101);
		// attack hits if it falls inside accuracy boundary
		if(randNum <= ACCURACY) {
			// if attack is accurate, move on to superclass to calculate damage
			return super.Attack(pokemon);
		}
		// else, return message stating the attack missed
		else
			return "The attack missed!";
		
	}
}
