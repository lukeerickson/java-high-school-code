package pokemonProject;

import java.util.Random;

/*
 * Author:	Luke Erickson
 * Date:	2/3/20
 * Period:	7th
 * 
 * Description: Interacts w/ player, providing them information about the battle, including
 * if their attacks hit or miss, if their pokemon faint, and at the end, if they win or lose
 * 				
 */

public class PokemonDriver 
{
	// rand
	private static Random rand;
	
	// Use the constants below as a way to assign your randomly generated numbers to Pokemon
	private static final int BULBASAUR = 1;
	private static final int IVYSAUR = 2;
	private static final int VENUSAUR = 3;
	private static final int SQUIRTLE = 4;
	private static final int WARTORTLE = 5;
	private static final int BLASTOISE = 6;
	private static final int CHARMANDER = 7;
	private static final int CHARMELEON = 8;
	private static final int CHARIZARD = 9;
	
	// Use the constant below as the maximum number of Pokemon each player gets
	private static final int NUM_POKEMON = 3;
	
	// Use the constants below as attack values for stage 1, stage 2, and stage 3 Pokemon
	private static final int STAGE_1 = 25;
	private static final int STAGE_2 = 35;
	private static final int STAGE_3 = 45;
	
	// Use the constants below as the names for each stage (1, 2, 3)
	// of each Pokemon type (Grass, Fire, Water)
	private static final String GRASS1 = "Bulbasaur";
	private static final String GRASS2 = "Ivysaur";
	private static final String GRASS3 = "Venusaur";
	private static final String FIRE1 = "Charmander";
	private static final String FIRE2 = "Charmeleon";
	private static final String FIRE3 = "Charizard";
	private static final String WATER1 = "Squirtle";
	private static final String WATER2 = "Wartortle";
	private static final String WATER3 = "Blastoise";
	
	// Use the constants below as the cries for each specific stage (1, 2, 3)
	// of each different Pokemon (Fire1, Fire2, Fire3, Water1, Water2, Water3, Grass1, Grass2, Grass3)
	private static final String FIRE1_CRY = "Char, char...*cough*!";
	private static final String FIRE2_CRY = "Char...meeeeeleon!";
	private static final String FIRE3_CRY = "CHARIZAAAAAAAAARD!";
	private static final String WATER1_CRY = "Squirtle, Squirtle...Squirt Squirt!";
	private static final String WATER2_CRY = "Wartor-tor-tortle!";
	private static final String WATER3_CRY = "BLAAAAASSSTOOIIIIISSE!";
	private static final String GRASS1_CRY = "Bulba...Bulba...Bulbasaur!";
	private static final String GRASS2_CRY = "*Grumble Grumble*...Ivysooooooaaaar!";
	private static final String GRASS3_CRY = "VENUSAAAUUUUR!";
	
	/**
	 * Description: 
	 */
	public static void main(String[] args) {
		Pokemon[] playerArray = new Pokemon[NUM_POKEMON];
		Pokemon[] NPCArray = new Pokemon[NUM_POKEMON];
		fillPokemon(playerArray);
		fillPokemon(NPCArray);
		
		int playerWins = 0;
		int NPCWins = 0;
		int count = 0;
		int battle = 1;
		
		System.out.println("***************************************");
		System.out.println("******** LET THE BATTLE BEGIN! ********");
		System.out.println("***************************************\n\n");
		
		while(count < NUM_POKEMON) {
			System.out.println("*** Battle #" + battle + ": " + playerArray[count].getName() + " vs " + NPCArray[count].getName() + " ***\n");
			
			while(playerArray[count].isFaintedStatus() == false && NPCArray[count].isFaintedStatus() == false) {
				System.out.println("Me - " + playerArray[count].getName() + " " + playerArray[count].Attack(NPCArray[count]));
				System.out.println("CP - " + NPCArray[count].getName() + " " + NPCArray[count].Attack(playerArray[count]));
				if(playerArray[count].getHealth() <= 0) {
					System.out.println("\n\tNO! " + playerArray[count].getName() + " has fainted!\n\t" + playerArray[count].getCry() + "\n");
					playerArray[count].setFaintedStatus(true);
					playerWins += 1;
				}
				if(NPCArray[count].getHealth() <= 0) {
					System.out.println("\n\tGot'em! " + NPCArray[count].getName() + " has fainted!\n\t" + NPCArray[count].getCry() + "\n");
					NPCArray[count].setFaintedStatus(true);
					NPCWins += 1;
				}		
			}
			count++;
			battle++;
		}
		
		if(playerWins > NPCWins) {
			System.out.println("***************************************");
			System.out.println("**********    W I N N E R    **********");
			System.out.println("***************************************\n\n");
		}
		
		if(playerWins < NPCWins) {
			System.out.println("***************************************");
			System.out.println("***********    L O S E R    ***********");
			System.out.println("***************************************\n\n");
		}
		
		if(playerWins == NPCWins) {
			System.out.println("***************************************");
			System.out.println("************    T I E R    ************");
			System.out.println("***************************************\n\n");
		}
		
		System.out.println("Number of battles won: " + playerWins);
		System.out.println("Number of battles lost: " + NPCWins);
	}
	
	/**
	 * Description: Fills an array with a number of pokemon equal to the NUM_POKEMON variable
	 * Each randomly generated number 1-9, corresponds with a different pokemon, which
	 * is instantiated and then added to the array
	 */
	private static void fillPokemon(Pokemon[] array)
	{
		
		int count = 0;
		rand = new Random();
		while(count < NUM_POKEMON)
		{
			int num = rand.nextInt(9) + 1;
			if(num == BULBASAUR) {
				Pokemon poke = new Grass1(GRASS1, GRASS1_CRY, STAGE_1);
				array[count] = poke;
			}
			if(num == IVYSAUR) {
				Pokemon poke = new Grass2(GRASS2, GRASS2_CRY, STAGE_2);
				array[count] = poke;
			}
			if(num == VENUSAUR) {
				Pokemon poke = new Grass3(GRASS3, GRASS3_CRY, STAGE_3);
				array[count] = poke;
			}
			if(num == SQUIRTLE) {
				Pokemon poke = new Water1(WATER1, WATER1_CRY, STAGE_1);
				array[count] = poke;
			}
			if(num == WARTORTLE) {
				Pokemon poke = new Water2(WATER2, WATER2_CRY, STAGE_2);
				array[count] = poke;
			}
			if(num == BLASTOISE) {
				Pokemon poke = new Water3(WATER3, WATER3_CRY, STAGE_3);
				array[count] = poke;
			}
			if(num == CHARMANDER) {
				Pokemon poke = new Fire1(FIRE1, FIRE1_CRY, STAGE_1);
				array[count] = poke;
			}
			if(num == CHARMELEON) {
				Pokemon poke = new Fire2(FIRE2, FIRE2_CRY, STAGE_2);
				array[count] = poke;
			}
			if(num == CHARIZARD) {
				Pokemon poke = new Fire3(FIRE3, FIRE3_CRY, STAGE_3);
				array[count] = poke;
			}
			
			count++;
		}		
		
	}
}


