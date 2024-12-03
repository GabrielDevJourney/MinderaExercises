package DynamicArrayExercise;

import java.util.Iterator;

public class DynamicArray implements Iterable {
	private int[] array;
	private int indexSize;
	Iterator iterator;

	public DynamicArray(int[] array) {
		this.array = array;
		this.indexSize = array.length - 1;
		this.iterator = iterator();
	}

	@Override
	public Iterator iterator() {
		return new MyIterator(array);
	}

	public void add(int number) {
		int counter = 0;

		//as reach limit
		if (indexSize == array.length) {

			int newSize = indexSize++;
			int[] newArray = new int[newSize];

			while (iterator.hasNext()) {
				newArray[counter] = (int)iterator.next(); //cast iterator return object
				counter++;
			}

			newArray[newSize] = number;
			array = newArray;
			indexSize++;
			iterator = iterator();

		} else {
			array[indexSize] = number;
		}
	}

	public void remove(int number) {
		int[] newArray = new int[indexSize--];

		//cuz i am doing follow up operations after add i need to update the current array to the one that add has
		// created otherwise will an empty array that i will be trying to access
		iterator = iterator();

		int j = 0;

		while (iterator.hasNext()){
			//variable to not repeat code
			int currentNumber = (int)iterator.next();
			if(currentNumber != number){
				newArray[j] = currentNumber;
				j++;
			}
		}

		//letting know that array is now smaller since is dynamic will always utilize indexSize so must be updated
		array = newArray;
		indexSize--;
		iterator = iterator();
	}

	public void print() {
		//just get current list and print it content
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

}
