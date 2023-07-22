package unit4Lab;

// CODE COMMENTS

public class Book {
	
	private String title, author, productCode;
	private int publishYear, quantityInStock, productNum;
	private boolean isNewRelease;
	private static int nextProductNum = 100;
	
	// everything constructor
	// all variables are chosen by the user
	/**
	 * @param aTitle
	 * @param anAuthor
	 * @param aPublishYear
	 * @param aQuantityInStock
	 */
	public Book(String aTitle, String anAuthor, int aPublishYear, int aQuantityInStock){
		title = aTitle;
		author = anAuthor;
		publishYear = aPublishYear;
		quantityInStock = aQuantityInStock;
		
		if (publishYear >= 2019)
			isNewRelease = true;
		else
			isNewRelease = false;
		
		productNum = nextProductNum;
		nextProductNum++;
		
		String productString = author.substring(0,3);
		productCode = productString + productNum;
	
		}
	
	/**
	 * @param num
	 */
	public void updateInventory(int num) {
		quantityInStock += num;
	}
	
	/**
	 *
	 */
	public String toString() {
		String str;
		if(isNewRelease)
			str = "a new release";
		else
			str = "not a new release";
		
		String str2;
		if(quantityInStock == 0)
			str2 = "out of stock";
		else
			str2 = quantityInStock + " copies";
		
		String output = productCode + "\t" + author + "\t\t" + title + ", " + publishYear + ", " + str + ", " + str2;
		return output;
	}
	


	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * @return
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return
	 */
	public int getProductNum() {
		return productNum;
	}

	/**
	 * @param productNum
	 */
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	/**
	 * @return
	 */
	public int getPublishYear() {
		return publishYear;
	}

	/**
	 * @param publishYear
	 */
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	/**
	 * @return
	 */
	public int getQuantityInStock() {
		return quantityInStock;
	}

	/**
	 * @param quantityInStock
	 */
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	/**
	 * @return
	 */
	public boolean isNewRelease() {
		return isNewRelease;
	}

	/**
	 * @param isNewRelease
	 */
	public void setNewRelease(boolean isNewRelease) {
		this.isNewRelease = isNewRelease;
	}

	/**
	 * @return
	 */
	public int getNextProductNum() {
		return nextProductNum;
	}
}
