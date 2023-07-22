package ws2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Fibonacci {
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		System.out.println(fibon(6));
		System.out.println(fibon(10));
		
		int num = 6;
		for (int i = 0; i <= num; i++)
			System.out.print(fibon(i) + " ");
		System.out.println();
		
		num = 10;
		for (int i = 0; i <= num; i++)
			System.out.print(fibon(i) + " ");
	}
	
	public static int fibon(int n)
	{
		if(n <= 2)
			return 1;
		else
			return fibon(n-1) + fibon(n-2);		
	}
	// fibon(1) = 1
	// fibon(2) = 1
	// fibon(3) = 2
	// fibon(4) = 3
	// fibon(5) = 5
	// fibon(6) = 8
	// fibon(7) = 13
	// fibon(8) = 21
	
	//1
	//1
	//2
	//3
	//5
	//8
	//13
	//21
	
	//if n == 6, return 1 1 2 3 5 8
}
