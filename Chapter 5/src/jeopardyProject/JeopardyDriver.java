package jeopardyProject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * Author:	Julian Trujillo & Luke Erickson
 * Date:	12/16/19
 * Period:	7th
 * 
 * Description: Class necessary for interacting with the player - prompts the user for information including their name
 * Creates player objects to be called upon in Player class
 * Decides if a player has won the game or not, and ends the game if a player has more than 2000 points
 * 				
 */

public class JeopardyDriver {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Hello and welcome to Jeopardy! To start off, here are the rules:\n\tThis is a 2 player game where players switch off turns\n\tPick a category and question to answer to earn points\n\tThe first player to 2000 points wins\n\tGood luck!\nPlayer 1, what is your name?");
			
		String player1name = kb.nextLine();
		System.out.println("Thanks " + player1name + "! Player 2, what is your name?");
		String player2name = kb.nextLine();
		System.out.println("Thanks " + player2name + "! To start we will show you the board. " + player1name + " you will go first.");
		System.out.println();
		
		int player1points = 0;
		int player2points = 0;
		boolean isPlayer1Turn = true;
		Player player1 = new Player (player1name, player1points, isPlayer1Turn);
		Player player2 = new Player (player2name, player2points, !isPlayer1Turn);
		
		Board jeopardyBoard = new Board();
		jeopardyBoard.importQuestions();
		
		int currentPlayer1Points = 0;
		int currentPlayer2Points = 0;
		
		while(currentPlayer1Points < 2000 || currentPlayer2Points < 2000) {
			if(isPlayer1Turn) {
				System.out.println("It is " + player1name + "'s turn");
				jeopardyBoard.displayBoard();
				isPlayer1Turn = player1.takeMyTurn(jeopardyBoard);
				currentPlayer1Points = player1.getPoints();
				currentPlayer2Points = player2.getPoints();
				System.out.println(player1name + "'s Current Points: " + currentPlayer1Points);
				System.out.println(player2name + "'s Current Points: " + currentPlayer2Points);
				System.out.println();
			}	
			else {
				System.out.println("It is " + player2name + "'s turn");
				jeopardyBoard.displayBoard();
				isPlayer1Turn = player2.takeMyTurn(jeopardyBoard);
				currentPlayer2Points = player2.getPoints();
				currentPlayer1Points = player1.getPoints();
				currentPlayer2Points = player2.getPoints();
				System.out.println(player1name + "'s Current Points: " + currentPlayer1Points);
				System.out.println(player2name + "'s Current Points: " + currentPlayer2Points);
				System.out.println();
			}	
		}	
		
		if(currentPlayer1Points > 2000) {
			System.out.println("Congratulations " + player1name + "! You have won the game!");
		}
		else {
			System.out.println("Congratulations " + player2name + "! You have won the game!");
		}
	}
}
