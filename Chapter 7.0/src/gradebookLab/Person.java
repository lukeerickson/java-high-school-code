package gradebookLab;

/*
 * Author:	Luke Erickson
 * Teacher: Mr. Nichols
 * Period:	7th
 * 
 * Description: 
 * 				
 */

public class Person {
	private String name;
	private int age;
	
	/**
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
