package minderaExercices.rockPaperScissors;

import java.util.Scanner;
import java.util.InputMismatchException; //to catch if input type different from expected


public class GameManager {
	private int userFinalChoice;
	private Scanner gameScanner;
	//since there are only 3 otpions it is safer and better to have 2 final variables that dictate from where to
	// where are available options
	private static final int MIN_OPTION = 1;
	private static final int MAX_OPTION = 3;
	private Game initializeGame;

	public GameManager() {
		gameScanner = new Scanner(System.in);
		initializeGame = new Game();
		handleUserModeInput();
	}

	public Game getInitializeGame() {
		return initializeGame;
	}

	public void handleUserModeInput() {
		int userchoice = 0;
		do {
			System.out.println("\nEnter game mode:");
			System.out.println("1. Bot vs Bot");
			System.out.println("2. Bot vs User");
			System.out.println("3. User vs User");
			System.out.print("Your choice (1-3): ");
			try {
				if (gameScanner.hasNextInt()) {
					userchoice = gameScanner.nextInt();
					gameScanner.nextLine(); //clean because of correct entry

					if (userchoice >= 1 && userchoice <= 3) {
						userFinalChoice = userchoice;
						break;
					} else {
						System.out.println("Input a valid option from 1 to 3");
					}
				} else {
					gameScanner.nextLine();
					System.out.println("Input new option");
				}
			} catch (InputMismatchException e){
				gameScanner.nextLine();
				System.out.println("Invalid input, please enter a number!");
			}
		} while (true);
		handleModeBasedOnChoice();
	}

	public void handleModeBasedOnChoice(){
		switch (userFinalChoice){
			case 1 : {
				initializeGame.modeBotVsBot();
				break;
			}
			case 2 : {
				initializeGame.modeBotVsPlayer();
				break;
			}
			case 3 : {
				initializeGame.modeUserVsUser();
				break;
			}
			default:{
				System.out.println("Choose a game mode");
				break;
			}
		}
	}

}
