package minderaExercices.BearShop;

public class Main {
	public static void main(String[] args) {
		Shop bearShop = new Shop("Shop1");
		bearShop.createBears(2);
		bearShop.createBears(5);
		bearShop.createBears(11);
		bearShop.createBears(10);
		Shop bearShop1 = new Shop("Shop2");
		bearShop1.createBears(10);
		bearShop1.createBears(11);
		bearShop1.createBears(5);
		bearShop1.createBears(2);
		System.out.println("\n" + bearShop.compareToOtherStore(bearShop1));
	}
}
