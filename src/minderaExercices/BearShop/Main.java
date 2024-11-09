package minderaExercices.BearShop;

public class Main {
	public static void main(String[] args) {
		Shop bearShop = new Shop("Shop1");
		bearShop.createBears(10);
		System.out.println(bearShop.getBearCounter());
		System.out.println("\n");

		Shop bearShop1 = new Shop("Shop2");
		bearShop1.createBears(12);
		System.out.println(bearShop1.getBearCounter());

		System.out.println("\n" + bearShop.compareToOtherStore(bearShop1));
	}
}
