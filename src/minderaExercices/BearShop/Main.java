package minderaExercices.BearShop;

public class Main {
	public static void main(String[] args) {
		Shop bearShop = new Shop("Shop1");
		bearShop.createBears();
		bearShop.createBears();
		bearShop.createBears();
		bearShop.createBears();
		bearShop.createBears();

		System.out.println("\n");

		Shop bearShop1 = new Shop("Shop2");
		bearShop1.createBears();
		bearShop1.createBears();
		bearShop1.createBears();
		bearShop1.createBears();
		System.out.println("\n" + bearShop.compareToOtherStore(bearShop1));
	}
}
