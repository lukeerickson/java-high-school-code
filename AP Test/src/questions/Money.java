package questions;

public class Money {
	private int dollars;
	private int cents;
	
	public Money(int dollars, int cents)
	{
		this.dollars = dollars;
		this.cents = cents;
	}
	
	public String toString()
	{
		return "$" + dollars + "." + cents;
	}
	
	public void add(int dollars, int cents)
	{
		this.dollars += dollars;
		this.cents += cents;
		convert();		
	}
	
	public void add(Money cash)
	{
		this.dollars += cash.getDollars();
		this.cents += cash.getCents();
		convert();
	}
	
	public void convert() {
		if(this.cents >= 100) {
			this.dollars += 1;
			this.cents -= 100;
		}
	}
	
	public int getDollars()
	{
		return dollars;
	}
	
	public int getCents()
	{
		return cents;
	}
}
