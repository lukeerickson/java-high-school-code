package jeopardyProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



/*
 * Author:	Julian Trujillo & Luke Erickson
 * Date:	12/16/19
 * Period:	7th
 * 
 * Description: Contains info needed to create the board, display it to the user, and decide if a user has answered their question correctly
 * Imports questions from text file and stores them as objects inside of a 2D arrayList
 * Also displays board depending on whether a question has been previously answered or not
 * Lastly, uses toString from Question method to prompt user with question and decide if they have answered correctly or not	
 */

public class Board {
	private Question[][] jeopardyBoard = new Question [5][5];
	private Scanner inF;
	private Scanner kb = new Scanner(System.in);
	
	public void importQuestions() throws IOException, FileNotFoundException{
		inF = new Scanner(new File("questions.txt"));
		
		int col = 0;
		int row = 0;
		
		while(inF.hasNextLine()) {
			String category = inF.nextLine();
			String questionTitle = inF.nextLine();
			String answerA = inF.nextLine();
			String answerB = inF.nextLine();
			String answerC = inF.nextLine();
			String answerD = inF.nextLine();
			String correctAnswer = inF.nextLine();
			int points = inF.nextInt();
			//dummy read
			inF.nextLine();
			Boolean hasBeenSelected = false;
			
			jeopardyBoard[row][col] = new Question(category, questionTitle, answerA, answerB, answerC, answerD, correctAnswer, points, hasBeenSelected);
			row++;
			
			if(row == 5) {
				row = 0;
				col++;
			}			
		}
	}
	
	/**
	 * Description: Displays appropriate categories and point values of each question
	 * If a question has already been answered, the board displays this accordingly
	 */
	public void displayBoard() {
		System.out.println("President Chester Arthur\tGeography\tBowling\t\tNature\t\tComputer Science");
		
		for(int row = 0; row < jeopardyBoard.length; row++)
			for(int col = 0; col < jeopardyBoard[row].length; col++) {
				if(jeopardyBoard[row][col].getHasBeenSelected() == false)
					System.out.print(jeopardyBoard[row][col].getPoints() + "\t\t");
				else
					System.out.print("Answered\t");
				if(col == 0)
					System.out.print("\t\t");
				if(col == 4)
					System.out.println();
			}
				
		System.out.println();
	}
	
	/**
	 * Description: Prompts player for category, points, and then the question itself
	 * Decides if the player has gotten the question right and assigns point values accordingly
	 * @param currentPoints
	 * @return pointsEarned
	 */
	public int takeTurn(int currentPoints) {
		int category = 0;
		int points = 0;
		
		boolean isCorrect = false;	
		while(!isCorrect) {
			System.out.println("Enter the category you would like!");
			System.out.println("\tFor \"President Chester Arthur\" enter 1");
			System.out.println("\tFor \"Geography\" enter 2");
			System.out.println("\tFor \"Bowling\" enter 3");
			System.out.println("\tFor \"Nature\" enter 4");
			System.out.println("\tFor \"Computer Science\" enter 5");
			
			boolean isValid = false;
			while (!isValid) {
				try {
					category = kb.nextInt() - 1;
					if(category < 0) {
						System.out.println("Please don't enter a number less than 1! Please try again.");
					}
					else if(category > 4) {
						System.out.println("Please don't enter a number greater than 5! Please try again.");
					}
					else {
						isValid = true;
					}
				}
				catch(Exception e) {
					System.out.println("You did not enter a valid number, try again.");
					kb.nextLine();
				}
			}	
			System.out.println();
			
			System.out.println("Enter the point value you would like!");
			System.out.println("\tFor \"100\" enter 1");
			System.out.println("\tFor \"200\" enter 2");
			System.out.println("\tFor \"300\" enter 3");
			System.out.println("\tFor \"400\" enter 4");
			System.out.println("\tFor \"500\" enter 5");
				
			boolean isTrue = false;
			while (!isTrue) {
				try {
					points = kb.nextInt() - 1;
					if(jeopardyBoard[points][category].getHasBeenSelected() == true)
						System.out.println("That question has already been answered. Please try another question.");
					else
						isCorrect = true;		
					if(points < 0) {
						System.out.println("Please don't enter a number less than 1! Please try again.");
					}
					else if(points > 4) {
						System.out.println("Please don't enter a number greater than 5! Please try again.");
					}
					else {
						isTrue = true;
					}
				}
				catch(Exception e) {
					System.out.println("You did not enter a valid number, try again.");
					kb.nextLine();
				}
			}
			System.out.println();
		}
		
		System.out.println(jeopardyBoard[points][category]);
		jeopardyBoard[points][category].setHasBeenSelected(true);
		String answer = "";
		
		boolean isNotWrong = false;
		while (!isNotWrong) {
			answer = kb.next();
			answer = answer.toUpperCase();
			if(!answer.equals("A") && !answer.equals("B") && !answer.equals("C") && !answer.equals("D")) {
				System.out.println("Please enter A, B, C, or D.");
			}
			else {
				isNotWrong = true;
			}
		}
		
		String correctAnswer = jeopardyBoard[points][category].getCorrectAnswer();
		
		if(answer == "A") 
			answer = jeopardyBoard[points][category].getAnswerA();
		else if(answer == "B")
			answer = jeopardyBoard[points][category].getAnswerB();
		else if(answer == "C")
			answer = jeopardyBoard[points][category].getAnswerC();
		else if(answer == "D")
			answer = jeopardyBoard[points][category].getAnswerD();
		
		if(answer.equals(correctAnswer)) {
			System.out.println("Congrats! You got the correct answer.");
			return jeopardyBoard[points][category].getPoints();
		}
		else {
			System.out.println("Sorry! You did not enter the correct answer! The correct answer was " + correctAnswer);
			return 0;
		}
	}
}
