package pokemonProject;
import java.util.Random;

public class Grass1 extends GrassType {
	private static Random rand;
	private static final int ACCURACY = 70;
	
	public Grass1(String name, String cry, int attack) {
		super(name, cry, attack);
	}
	
	public String Attack(Pokemon pokemon) {
		rand = new Random();
		int randNum = rand.nextInt(101);
		if(randNum <= ACCURACY) {
			return super.Attack(pokemon);
		}
		else
			return "The attack missed!";
		
	}

}
