package gradebookLab;

import java.util.ArrayList;


/*
 * Author:	Luke Erickson
 * Teacher: Mr. Nichols
 * Period:	7th
 * 
 * Description: 
 * 				
 */

public class Gradebook {
	private ArrayList<Student> students = new ArrayList<Student>(11);
	//private Student[] students = new Student[11];
	private int period;
	
	/**
	 * @param students
	 * @param period
	 */
	public Gradebook(ArrayList<Student> students, int period)
	{
		this.students = students;
		this.period = period;
	}
	
	/**
	 * @param stu
	 */
	public void addStudent(Student stu) 
	{
		students.add(stu);
	}
	
	/**
	 * Uses selection sort to sort every celebrity in the class by last name in alphabetical order
	 */
	public void sortLastNameAZ()
	{
		
		int min;
		Student temp;
		
		for(int index = 0; index < students.size()-1; index++)
		{
			min = index;
			for(int scan = index+1; scan < students.size(); scan++)
				if(students.get(scan).getLastName().toLowerCase().compareTo(students.get(min).getLastName().toLowerCase()) < 0)
					min = scan;

		// Swap the values
			temp = students.get(min);
			students.set(min, students.get(index));
			//students.get(min).setName(students.get(index).getName());
			students.set(index, temp);
			
		}
		
	}
	
	/**
	 * Uses selection sort to sort every celebrity in the class by last name in reverse alphabetical order
	 */
	public void sortLastNameZA()
	{
		int min;
		Student temp;
		
		for(int index = 0; index < students.size()-1; index++)
		{
			min = index;
			for(int scan = index+1; scan < students.size(); scan++)
				if(students.get(scan).getLastName().toLowerCase().compareTo(students.get(min).getLastName().toLowerCase()) > 0)
					min = scan;
			
		// Swap the values
			temp = students.get(min);
			students.set(min, students.get(index));
			students.set(index, temp);
	}
	}
	
	/**
	 * Uses insertion sort to sort every celebrity in the class by average test score, from low to high
	 */
	public void sortAvgLowHigh()
	{
		for(int index = 1; index < students.size(); index++)
		{
			Student key = students.get(index);
			int position = index;
			
			//shift larger values to the right
			while(position > 0 && students.get(index-1).getAverage() > key.getAverage())
			{
				students.set(index, students.get(index-1));
				position--;
			}
			students.set(index, key);
		}
	}
	
	/**
	 * Uses insertion sort to sort every celebrity in the class by average test score, from high to low
	 */
	public void sortAvgHighLow()
	{
		for(int index = 1; index < students.size(); index++)
		{
			Student key = students.get(index);
			int position = index;
			
			//shift larger values to the left
			while(position > 0 && students.get(index-1).getAverage() < key.getAverage())
			{
				students.set(index, students.get(index-1));
				position--;
			}
			students.set(index, key);
		}
	}
	
	/**
	 * Uses binary search to search through a class and find if a student with an entered last name is in that class
	 * @param name
	 * @return found student
	 */
	public String search(String name)
	{
		this.sortLastNameAZ();
		
		String str = "\n";
		name = name.toLowerCase();
		
		int low = 0, high = students.size()-1, middle = (low + high) / 2;
		
		while(!students.get(middle).getLastName().toLowerCase().contains(name) && low <= high) {
			if(name.compareTo(students.get(middle).getLastName().toLowerCase()) < 0)
				high = middle - 1;
			else
				low = middle + 1;
			middle = (low + high) / 2;
		}
	
		if(students.get(middle).getLastName().toLowerCase().contains(name)) {
			str += "Student was found!\n\nLast Name, First Name\t\tTest#1\t\tTest#2\t\tTest#3\t\tAverage\n\n";
			str += students.get(middle).toString();
			return str;
		}
		else
			return "Student was not found";
			
	}
	
	/**
	 * Header for printing out all of the students in a class
	 */
	public String toString()
	{
		String str = "\n\t\t *** Period " + getPeriod() + " ***\n\n";
		str += "Last Name, First Name\t\tTest#1\t\tTest#2\t\tTest#3\t\tAverage\n\n";
		
		for(int i = 0; i < getStudents().size(); i++) {
			str += getStudents().get(i).toString();
		}
		return str;
	}

	/**
	 * @return
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}

	/**
	 * @param students
	 */
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	/**
	 * @return
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @param period
	 */
	public void setPeriod(int period) {
		this.period = period;
	}
	
}
