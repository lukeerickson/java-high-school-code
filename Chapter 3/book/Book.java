package book;

public class Book {
	
	private String title, author, productNum;
	private int publishYear, quantityInStock;
	private boolean isNewRelease;
	
	private final int nextBookNum = 100;
	
	// everything constructor
	// all variables are chosen by the user
	/**
	 * @param aBalance
	 * @param aPinNum
	 * @param anAccountNum
	 * @param aBankName
	 * @param aName
	 */
	public boolean createBook(String aTitle, String anAuthor, int aPublishYear, int aQuantityInStock)
		{
		
		title = aTitle;
		author = anAuthor;
		publishYear = aPublishYear;
		quantityInStock = aQuantityInStock;
		
		if (publishYear >= 2019)
			isNewRelease = true;
		else
			isNewRelease = false;
		
		return isNewRelease;
		
		}
	
	public static void main(String[] args)
	{
		
		
		
	}
}
