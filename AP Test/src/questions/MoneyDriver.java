package questions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MoneyDriver {
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		Money m = new Money(3,42);
		System.out.println(m.toString());
		
		m.add(2,15);
		System.out.println(m.toString());
		
		m.add(0,60);
		System.out.println(m.toString());
		
		Money allowance = new Money(5, 00);
		m.add(allowance);
		System.out.println(m.toString());
		System.out.println(allowance.toString());
	}
}
