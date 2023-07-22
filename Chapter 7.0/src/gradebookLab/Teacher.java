package gradebookLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Author:	Luke Erickson
 * Teacher: Mr. Nichols
 * Period:	7th
 * 
 * Description: 
 * 				
 */

public class Teacher extends Person {
	private String subject;
	private Gradebook[] gradebooks = new Gradebook[5];
	//private ArrayList<Gradebook> gradebooks = new ArrayList<Gradebook>(5);
	private Scanner inF = new Scanner(System.in);

	public static int i = 0;
	
	/**
	 * @param name
	 * @param age
	 * @param subject
	 */
	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}
	
	/**
	 * reads all 5 text files
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void fillGradebook() throws IOException, FileNotFoundException {
		
		inF = new Scanner(new File("Period1.txt"));
		readList(inF);
		
		inF = new Scanner(new File("Period2.txt"));
		readList(inF);
		
		inF = new Scanner(new File("Period3.txt"));
		readList(inF);
		
		inF = new Scanner(new File("Period7.txt"));
		readList(inF);
			
		inF = new Scanner(new File("Period8.txt"));
		readList(inF);
		
		}
	
	/**
	 * reads students from all 5 text files and inputs them into their appropriate class
	 * student variables firstName, lastName, age, and scores are all saved
	 * @param inF
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void readList(Scanner inF) throws IOException, FileNotFoundException {
		
		ArrayList<Student> students = new ArrayList<Student>(11);
		
		int period = 0;
		
		if(i == 0)
			period = 1;
		if(i == 1)
			period = 2;
		if(i == 2)
			period = 3;
		if(i == 3)
			period = 7;
		if(i == 4)
			period = 8;
		
		gradebooks[i] = new Gradebook(students, period);
		
		int count = 0;
		
		while(inF.hasNextLine()) {
			// student variables
			String firstName = inF.next();
			String lastName = inF.next();
			int age = inF.nextInt();
			int[] scores = new int[3];
			scores[0] = inF.nextInt();
			scores[1] = inF.nextInt();
			scores[2] = inF.nextInt();
			//dummy read
			if(inF.hasNextLine())
				inF.nextLine();
			
			// create student object
			Student stu = new Student(firstName, lastName, age, scores);
			
			// add student to appropriate period
			gradebooks[i].addStudent(stu);
		
			count++;

			}
		i++;
	}
	
	/**
	 * Summarize teacher's classes in a string
	 */
	public String toString()
	{
		return "\t\t***" + getName() + "; " + gradebooks[i].getPeriod() + " ***\n" + gradebooks[i].toString();
		//String str = "";
		//for(int i = 0; i < gradebooks.length; i++)
			//str += gradebooks[i].toString();
		//return str;
	}

	/**
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return
	 */
	public Scanner getInF() {
		return inF;
	}

	/**
	 * @param inF
	 */
	public void setInF(Scanner inF) {
		this.inF = inF;
	}

	/**
	 * @return
	 */
	public Gradebook[] getGradebooks() {
		return gradebooks;
	}

	/**
	 * @param gradebooks
	 */
	public void setGradebooks(Gradebook[] gradebooks) {
		this.gradebooks = gradebooks;
	}
	}

