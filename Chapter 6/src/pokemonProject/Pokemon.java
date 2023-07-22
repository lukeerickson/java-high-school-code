package pokemonProject;

public abstract class Pokemon 
{	
	private static final int START_HEALTH = 100;
	
	private String type;
	private String name;
	private String cry;
	private double health;
	private int attack;
	private boolean faintedStatus;
	
	// starting health is always 100 and pokemon always begin not being fainted
	public Pokemon(String type, String name, String cry, int attack) {
		this.type = type;
		this.name = name;
		this.cry = cry;
		this.attack = attack;
		health = START_HEALTH;
		faintedStatus = false;
	}
	
	public abstract String Attack(Pokemon pokemon);

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCry() {
		return cry;
	}

	public void setCry(String cry) {
		this.cry = cry;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public boolean isFaintedStatus() {
		return faintedStatus;
	}

	public void setFaintedStatus(boolean faintedStatus) {
		this.faintedStatus = faintedStatus;
	}
	
}
