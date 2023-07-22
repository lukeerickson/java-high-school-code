package tacoTruck;

public class TacoDriver {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Luke's Taco Truck");
		Taco myTaco = new Taco();
		myTaco.takeOrder();
		myTaco.printTacoOrder();
	}
}
