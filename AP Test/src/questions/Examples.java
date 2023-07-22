package questions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Examples {
	
	private static ArrayList<Integer> nums = new ArrayList<Integer>();
	private static int[] numbers = new int[10]; 
	
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		printArrayList();
		System.out.println();
		printArray();
		System.out.println();
		conversions();
	}
	
	public static void printArrayList()
	{
		//List<Integer> nums = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		
		//ArrayList<Integer> nums = new ArrayList<Integer>(10);
		
		nums.add(0);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(7);
		nums.add(8);
		nums.add(9);
		
		//for(int i: nums)
			//nums.add(i);
		for(int i = 0; i < nums.size(); i++)
		{
			System.out.print(nums.get(i) + " ");
		}
			
		
	}
	
	public static void printArray()
	{
		for(int i = 0; i < numbers.length; i++)
			numbers[i] = i;
		for(int num: numbers)
			System.out.print(num + " ");
	}
	
	public static void conversions()
	{
		int x = 11;
		int z = 5;
		double y = x/z;
		System.out.println(y);
		
		int total = 11;
		int count = 5;
		double result = (double)total / count;
		System.out.println(result);
	}
}
