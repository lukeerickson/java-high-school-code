package character;

public class Character {

	private String name;
	private String personality;
	private String job;
	
	public Character(String name, String personality, String job)
	{
		this.name = name;
		this.personality = personality;
		this.job = job;
	}
	
	public String toString() {
		String str;
			str = "Name: " + name + "\nPersonality: " + personality + "\nJob: " + job + "\n";
		return str;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
