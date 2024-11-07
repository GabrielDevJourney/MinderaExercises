package minderaExercices.inheritanceTest;

public class Main {
	public static void main(String[] args) {
		Vehicle bike2 = new Bike() {
		};

		Car car = new Car();
		Bike bike = new Bike();

		((Bike)bike2).wheelie();
		car.move();
	}
}
