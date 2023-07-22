package jeopardyProject;

/*
 * Author:	Julian Trujillo & Luke Erickson
 * Date:	12/16/19
 * Period:	7th
 * 
 * Description: Uses an everything Constructor to create the Question objects 
 * and a toString to return a String prompting the user of the question and its answer choices				
 */

public class Question {
	private String category, questionTitle, answerA, answerB, answerC, answerD, correctAnswer;
	private int points;
	private boolean hasBeenSelected;
	
	/**
	 * Description: Everything constructor - constructs question objects given category, point value, question, answer choices,
	 * correct answer, and whether the question has already been selected
	 * @param aCategory
	 * @param aQuestionTitle
	 * @param aAnswerA
	 * @param aAnswerB
	 * @param aAnswerC
	 * @param aAnswerD
	 * @param aCorrectAnswer
	 * @param aPoints
	 * @param aHasBeenSelected
	 */
	public Question(String aCategory, String aQuestionTitle, String aAnswerA, String aAnswerB, String aAnswerC, String aAnswerD, String aCorrectAnswer, int aPoints, boolean aHasBeenSelected) {
		category = aCategory;
		questionTitle = aQuestionTitle;
		answerA = aAnswerA;
		answerB = aAnswerB;
		answerC = aAnswerC;
		answerD = aAnswerD;
		correctAnswer = aCorrectAnswer;
		points = aPoints;
		hasBeenSelected = false;
		
	}
	
	/**
	 * Description: Concatenates a string containing question and answer choices
	 * @return questionTitle and list of answer choices
	 */
	public String toString() {
		String output = "The category is: " + category;
		output += "\n" + questionTitle;
		output += "\n\tA: " + answerA;
		output += "\n\tB: " + answerB;
		output += "\n\tC: " + answerC;
		output += "\n\tD: " + answerD;
		output += "\nWhat is your answer, A, B, C, or D?";
		return output;
	}

	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return questionTitle
	 */
	public String getQuestionTitle() {
		return questionTitle;
	}

	/**
	 * @param questionTitle
	 */
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	/**
	 * @return answerA
	 */
	public String getAnswerA() {
		return answerA;
	}

	/**
	 * @param answerA
	 */
	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	/**
	 * @return answerB
	 */
	public String getAnswerB() {
		return answerB;
	}

	/**
	 * @param answerB
	 */
	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	/**
	 * @return answerC
	 */
	public String getAnswerC() {
		return answerC;
	}

	/**
	 * @param answerC
	 */
	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	/**
	 * @return answerD
	 */
	public String getAnswerD() {
		return answerD;
	}

	/**
	 * @param answerD
	 */
	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	/**
	 * @return correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @param correctAnswer
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	/**
	 * @return points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * @return hasBeenSelected
	 */
	public boolean getHasBeenSelected() {
		return hasBeenSelected;
	}

	/**
	 * @param hasBeenSelected
	 */
	public void setHasBeenSelected(boolean hasBeenSelected) {
		this.hasBeenSelected = hasBeenSelected;
	}
	
}
