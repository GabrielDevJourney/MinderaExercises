package minderaExercices.guessingGame;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GameScanner {
	private Scanner guessingScanner;
	private int userFinalChoice;
	private int[] playerGuesses;

	public GameScanner() {
		guessingScanner = new Scanner(System.in);
		playerGuesses = Player.getPlayersGuesses();
	}

	public int getUserFinalChoice() {
		return userFinalChoice;
	}

	public void handleUserInput(Difficulty difficulty) {
		int userChoice = 0;
		int minRange = difficulty.getMinRange();
		int maxRange = difficulty.getMaxRange();
		do {
			System.out.println("\nEnter your guessing:");
			try {
				if (guessingScanner.hasNextInt()) {
					userChoice = guessingScanner.nextInt();
					guessingScanner.nextLine(); //clean because of correct entry

					if(checkUserGuess(userChoice, minRange,maxRange)){
						userFinalChoice = userChoice;
						break;
					} else {
						System.out.println("Input a valid option from " + minRange + " to " + maxRange);
					}
				} else {
					guessingScanner.nextLine();
					System.out.println("Input new guess");
				}
			} catch (InputMismatchException e) {
				guessingScanner.nextLine();
				System.out.println("Invalid input, please enter a number!");
			}
		} while (true);
	}

	private boolean checkUserGuess(int num, int minRange, int maxRange) {
		if (num >= minRange && num <= maxRange) {
			for (int i = 0; i < playerGuesses.length; i++) {
				if (num == playerGuesses[i]) {
					//reject duplicate number
					return false;
				}
			}
			//accept guess is new guess
			return true;
		}
		//number out or range so reject guess since is not with in the min and max
		return false;
	}
}
