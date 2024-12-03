package DynamicArrayExercise;

import java.util.Iterator;

public class MyIterator implements Iterator {
	private final int[] array;
	private int indexSize;

	public MyIterator(int[] array) {
		this.array = array;
	}

	@Override
	public boolean hasNext() {
		return indexSize < array.length;
	}

	@Override
	public Object next() {
		return array[indexSize++];
	}
}
