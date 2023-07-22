package pokemonProject;

public abstract class GrassType extends Pokemon
{
	private static final String GRASS = "Grass";
	private static final String WATER = "Water";
	private static final String FIRE = "Fire";
	private static final double INCREASE = 1.2;
	private static final double DECREASE = 0.8;
	
	private String strength = WATER;
	private String weakness = FIRE;
	
	public GrassType(String name, String cry, int attack) {
		super("Grass", name, cry, attack);
	}
	
	public String Attack(Pokemon pokemon) {
		double damage = this.getAttack();
		// damage increase according to typing
		if(pokemon.getType() == strength) 
			damage *= INCREASE;
		// damage decreases according to typing
		if(pokemon.getType() == weakness)
			damage *= DECREASE;
		// calculates new health
		pokemon.setHealth(pokemon.getHealth() - damage);
		return "The attack was successful!";	
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	
}
