package gradebookLab;

import java.text.DecimalFormat;

/*
 * Author:	Luke Erickson
 * Teacher: Mr. Nichols
 * Period:	7th
 * 
 * Description: 
 * 				
 */

public class Student extends Person {
	private String firstName;
	private String lastName;
	private int[] scores = new int[3];
	private double average = 0;
	private DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param scores
	 */
	public Student(String firstName, String lastName, int age, int[] scores)
	{
		super(firstName + " " + lastName, age);
		this.firstName = firstName;
		this.lastName = lastName;
		this.scores = scores;
		average = calcAverage(scores);
	}
	
	/**
	 * Take array of all 3 test scores and determine average of these 3 scores
	 * @param scores
	 * @return
	 */
	public double calcAverage(int[] scores)
	{
		double average = 0;
		for(int i = 0; i < scores.length; i++)
			average += scores[i];
		return average /= scores.length;
		//average = df.format(average);
		//return average;
		//return df.format(average);
	}
	
	/**
	 * Print student information matching with headers
	 * Provides an extra tab if needed so info is even
	 */
	public String toString()
	{		
		String str = "";
		String name = getLastName() + ", " + getFirstName();
		str += name;
		if(name.length() < 16)
			str += "\t";
		str += "\t\t" + getScores()[0] + "\t\t" + getScores()[1] + "\t\t" + getScores()[2] + "\t\t" + df.format(getAverage()) + "\n";
		//return getLastName() + ", " + getFirstName() + "\t" + getScores()[0] + "\t" + getScores()[1] + "\t" + getScores()[2] + "\t" + getAverage() + "\n";
		return str;
	}

	/**
	 * @return
	 */
	public int[] getScores() {
		return scores;
	}

	/**
	 * @param scores
	 */
	public void setScores(int[] scores) {
		this.scores = scores;
	}

	/**
	 * @return
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * @param average
	 */
	public void setAverage(double average) {
		this.average = average;
	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
