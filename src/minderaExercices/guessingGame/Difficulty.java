package minderaExercices.guessingGame;

public enum Difficulty {
	//this creates a more consice way to use difficulty levels and also more readble and consisnt
	//not allowing for mode to be change since its properties will be final this means no way they can be changed
	//also it allows me to have a better implementntaion rather then 1 2 3 for levels
	EASY(1, 20),      // min=1, max=20
	MEDIUM(1, 75),    // min=1, max=75
	HARD(1, 2000);     // min=1, max=150

	private final int minRange;
	private final int maxRange;

	// Constructor
	Difficulty(int minRange, int maxRange) {
		this.minRange = minRange;
		this.maxRange = maxRange;
	}

	// Getters
	public int getMinRange() {
		return minRange;
	}

	public int getMaxRange() {
		return maxRange;
	}


	public int calculateRange() {
		return getMaxRange() - getMinRange() + 1;
	}


}
