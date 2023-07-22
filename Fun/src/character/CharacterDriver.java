package character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class CharacterDriver {

	private static ArrayList<Character> NPCs = new ArrayList<Character>(0);
	private static String[] names = new String[125];
	private static String[] personalities = new String[20];
	private static String[] jobs = new String[35];
	private static Scanner inF = new Scanner(System.in);
	private static Random rand;
	private static int num;
	private static String name;
	private static String personality;
	private static String job;
	
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		Scanner kb = new Scanner(System.in);
		
		importNames();
		importPersonalities();
		importJobs();
		
		boolean restart = true;
		int i = 0;
		
		//always gives you the option to create more characters
		while(restart == true) {
			restart = false;
			//prompt for # of characters
			System.out.println("How many characters would you like to create?");
			int num = kb.nextInt();
			
				System.out.println("\nHere ya go:");
			
			//for(int i = 0; i < num; i++) {
				//generateCharacter();
				//System.out.println(NPCs.get(i));
			//}
		
				
			//generate characters equal to # inputted
			int j = i;
			
			while (i < j + num){
				generateCharacter();
				System.out.println(NPCs.get(i));
				i++;
			}
				
			
			restart = true;
		}	
	}
	
	public static void importNames() throws IOException, FileNotFoundException
	{
		inF = new Scanner(new File("names.txt"));
		int i = 0;
		
		while(inF.hasNextLine())
		{
			String name = inF.nextLine();
			names[i] = name;
			
			i++;	
		}
	}
	
	public static void importPersonalities() throws IOException, FileNotFoundException
	{
		inF = new Scanner(new File("personalities.txt"));
		int i = 0;
		
		while(inF.hasNextLine())
		{
			String personality = inF.nextLine();
			personalities[i] = personality;
			
			i++;
		}
	}
	
	public static void importJobs() throws IOException, FileNotFoundException
	{
		inF = new Scanner(new File("jobs.txt"));
		int i = 0;
		
		while(inF.hasNextLine())
		{
			String job = inF.nextLine();
			jobs[i] = job;
			
			i++;
		}
	}
	
	//come up with random character name, add it to NPCs arraylist
	public static void generateCharacter()
	{
		//if(name.contains(" ") || name.contains("'")) {
			//b = new Character(name, "");
		//}
		//else {
			//rand = new Random();
			//num = rand.nextInt(personalitys.length);
			//String personality = personalitys[num];
			//b = new Character(name, "");
		//}
		
		//generates random name
		rand = new Random();
		num = rand.nextInt(names.length);		
		name = names[num];
		
		
		//if a name has already been used, it finds a new name
		//boolean loop = true;
		//while(loop) {
			//loop = false;
			//for(int i = 0; i < NPCs.size(); i++) 
				//if(name == NPCs.get(i).getName()) 
					//loop = true;
			//if(loop == true) {
				//num = rand.nextInt(names.length);
				//name = names[num];
			//}	
		//}
		
		//checks to see that the new name has not already been chosen
		//otherwise, it generates a new name
		boolean loop = true;
		while(loop) {
			loop = false;
			for(int i = 0; i < NPCs.size(); i++) 
				if(name != NPCs.get(i).getName()) 
					loop = false;
				else {
					num = rand.nextInt(names.length);
					name = names[num];
					loop = true;
				}
		}
		
		//generates random personality
		rand = new Random();
		num = rand.nextInt(personalities.length);
		personality = personalities[num];
				
		//generates random job
		rand = new Random();
		num = rand.nextInt(jobs.length);
		job = jobs[num];
			

		
		Character b;
		
		b = new Character(name, personality, job);
		
		
		NPCs.add(b);	
	}
}
