package unit4Lab;

public class BookDriver {
	
	public static void main(String[] args) {
		
			//part 1
			Book book1 = new Book("Bana", "bAnana", 2019, 3);
			Book book2 = new Book("Apple", "Apple", 2018, 1);
			Book book3 = new Book("Grape", "Fruit", 2005, 1990);
			Book book4 = new Book("Grape", "Fruit", 2005, 1990);
			Book book5 = new Book("The Bible", "Jesus", 0, 1);
				
			//part 2		
			System.out.println(book1);
			System.out.println(book2);
			System.out.println(book3);
			System.out.println(book4);
			System.out.println(book5);
			
			System.out.println("");
			
			//part 3
			book2.updateInventory(2);
			book3.updateInventory(-1);
			System.out.println(book2);
			System.out.println(book3);
			
			System.out.println("");
			
			//part 4
			if(book3.getQuantityInStock() > 0)
				System.out.println("Book 3 is available for purchase!");
			else
				System.out.println("Book 3 is not available for purchase!");
			
			System.out.println("");
			
			//part 5
			if(book4.getQuantityInStock() > 0)
				System.out.println("Book 4 is available for purchase!");
			else
				System.out.println("Book 4 is not available for purchase!");
			
			System.out.println("");
			
			//part 6
			if(book1.isNewRelease())
				System.out.println("Book 1 is a new release!");
			else
				System.out.println("Book 1 is not a new release!");
			
			System.out.println("");
			
			//part 7
			if(book2.isNewRelease())
				System.out.println("Book 2 is a new release!");
			else
				System.out.println("Book 2 is not a new release!");
	}
}
