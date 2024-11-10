package minderaExercices.guessingGame;

public class Game {
	private int minRangeForRandomNumber;
	private int rangeForRandomNumber;

	//before was static but this way i can make each instance of a game have its random number
	private int randomNumberGenerated;

	//allowing to have a lot of game generated numbers since i can increase amount of game players
	private int[] gameAllRandomNums;

	private int counterAllRandomNums = 0;

	public Game() {
	}

	public int getRandomNumberGenerated() {
		return randomNumberGenerated;
	}

	public int getRangeForRandomNumber() {
		return rangeForRandomNumber;
	}

	public void setRangeForRandomNumber(int rangeForRandomNumber) {
		this.rangeForRandomNumber = rangeForRandomNumber;
	}

	public int getMinRangeForRandomNumber() {
		return minRangeForRandomNumber;
	}

	public void setMinRangeForRandomNumber(int minRangeForRandomNumber) {
		this.minRangeForRandomNumber = minRangeForRandomNumber;
	}


	public void setGameAllRandomNums(int gameAllRandomNums) {
		this.gameAllRandomNums = new int[gameAllRandomNums];
	}

	private boolean hasRandomNumber(int randomNumberGenerated) {
		for (int i = 0; i < counterAllRandomNums; i++) {
			if (gameAllRandomNums[i] == randomNumberGenerated) {
				return true;
			}
		}
		return false;
	}

	public void addRandomNumToArray(int randomNumberGenerated) {
		if (counterAllRandomNums < gameAllRandomNums.length) {
			gameAllRandomNums[counterAllRandomNums] = randomNumberGenerated;
			counterAllRandomNums++;
		}
	}

	public int generateGameNumber() {
		do {
			randomNumberGenerated = (int) (Math.random() * rangeForRandomNumber + 1) + minRangeForRandomNumber;
		} while (hasRandomNumber(randomNumberGenerated));
		addRandomNumToArray(randomNumberGenerated);
		return randomNumberGenerated;
	}

}
