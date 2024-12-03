package DynamicArrayExercise;

public class Main {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		DynamicArray myArray = new DynamicArray(array);


		myArray.add(12);
		myArray.print();
		myArray.remove(2);
		myArray.print();
	}
}
