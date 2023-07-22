package bankAccountReader;

public class BankAccount 
{
	// instance variables
	private double balance;
	private int pinNum, accountNum;
	private String bankName, name;
	private static int nextAccountNum = 123456789;
	
	// default constructor
	// initializes all instance variables to default values
	/**
	 * 
	 */
	public BankAccount()
	{
		balance = 0;
		pinNum = 1111;
		accountNum = nextAccountNum;
		nextAccountNum++;
		bankName = "Mr. Nichols' Bank for the Needy";
		name = "John H. Doe";
	}
	
	// overloaded constructor - having more than one constructor in the same class w/ the same name but different parameters
	
	// everything constructor
	// all variables are chosen by the user
	/**
	 * @param aBalance
	 * @param aPinNum
	 * @param anAccountNum
	 * @param aBankName
	 * @param aName
	 */
	public BankAccount(String aName, String aBankName, int aPinNum, double aBalance)
	{
		balance = aBalance;
		pinNum = aPinNum;
		accountNum = nextAccountNum;
		nextAccountNum++;
		bankName = aBankName;
		name = aName;
	}
	
	public void transfer(BankAccount other, double amount) // savings.transfer(checking, 100);
	{
		this.withdraw(amount);
		other.deposit(amount);
	}
	
	public void deposit    (double amount)
	{
		// savings.deposit(100);
		this.balance += amount;
	}
	
	public void withdraw (double amount)
	{
		this.balance -= amount;
	}

	public String toString()
	{
		String output = "Name: " + name;
		output += "\nBank Name: " + bankName;
		output += "\nPin Number: " + pinNum;
		output += "\nAccount Number: " + accountNum;
		output += "\nBalance: " + balance;
		return output;
	}
	
	// checking.compareTo(savings);
	// numbers come before letters
	// capital letters come before lowercase letters
	// alphabet
	
	// negative is in order
	// positive is out of order
	public int compareTo(BankAccount a)
	{
		if (this.balance < a.balance)
			return -1;
		else if (this.balance > a.balance)
			return 1;
		else
			return 0;
	}
	
	/**
	 * @return balance of account
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return pin number of account
	 */
	public int getPinNum() {
		return pinNum;
	}

	/**
	 * @param pinNum
	 */
	public void setPinNum(int pinNum) {
		this.pinNum = pinNum;
	}

	/**
	 * @return number of account
	 */
	public int getAccountNum() {
		return accountNum;
	}

	/**
	 * @param accountNum
	 */
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	/**
	 * @return name of bank
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return name of owner of account
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
	
}
