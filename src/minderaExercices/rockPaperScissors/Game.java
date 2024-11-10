package minderaExercices.rockPaperScissors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	//this part i used ai because i thought would be better to have colros in terminal for better understaing of what
	// is happening
	private static final String ANSI_BOLD = "\u001B[1m";
	private static final String ANSI_PURPLE = "\u001B[95m";      // Bright Purple
	private static final String ANSI_RED = "\u001B[91m";
	private static final String ANSI_GREEN = "\u001B[92m";
	private static final String ANSI_YELLOW = "\u001B[93m";
	private static final String ANSI_CYAN = "\u001B[96m";
	private static final String ANSI_MAGENTA = "\u001B[95m";  // For User
	private static final String ANSI_RESET = "\u001B[0m";

	
	private final int roundsToWin = 3;
	private final String[] choices = new String[]{"rock", "paper", "scissors"};
	private final Scanner userMoveScanner;
	private Player player1;
	private Player player2;
	private int userFinalMove;

	public Game() {
		userMoveScanner = new Scanner(System.in);
	}

	private String generateChoice() {
		int randomIndex = (int) (Math.random() * choices.length);
		String playerChoice = choices[randomIndex];
		return playerChoice;
	}

	//based on type of player the way choice is generated changes
	private void playerChoice() {
		//here the logic can be similar to the blackjack having a handler for if has round
		if (player1.getPlayerType().equals("bot")) {
			player1.setCurrentChoice(generateChoice());
		} else {
			player1.setCurrentChoice(convertUserMove(handlePlayerGame()));
		}
		if (player2.getPlayerType().equals("user")) {
			player2.setCurrentChoice(convertUserMove(handlePlayerGame()));
		} else {
			player2.setCurrentChoice(generateChoice());
		}
	}

	private int compareChoices() {
		String player1Choice = player1.getCurrentChoice();
		String player2Choice = player2.getCurrentChoice();

		if (player1Choice.equals(player2Choice)) {
			System.out.println(ANSI_YELLOW + "Both chose " + player1Choice + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "Round Tie!" + ANSI_RESET);
			return -1;
		}

		// Always keep Bot in CYAN and its choices in RED
		// Always keep User in MAGENTA and its choices in GREEN
		System.out.println(
				ANSI_CYAN + player1.getName() + ANSI_RESET + " " +
						ANSI_RED + player1Choice + ANSI_RESET + " | " +
						ANSI_MAGENTA + player2.getName() + ANSI_RESET + " " +
						ANSI_GREEN + player2Choice + ANSI_RESET
		);

		if ((player1Choice.equals("rock") && player2Choice.equals("scissors")) ||
				(player1Choice.equals("paper") && player2Choice.equals("rock")) ||
				(player1Choice.equals("scissors") && player2Choice.equals("paper"))) {
			System.out.println(ANSI_CYAN + player1.getName() + " wins this round!" + ANSI_RESET);
			return 0;
		} else {
			System.out.println(ANSI_MAGENTA + player2.getName() + " wins this round!" + ANSI_RESET);
			return 1;
		}
	}

	public void startGame() {
		System.out.println(ANSI_YELLOW + ANSI_BOLD + "\n*** GAME START! ***" + ANSI_RESET);
		while (player1.getPlayerScore() < roundsToWin && player2.getPlayerScore() < roundsToWin) {
			playerChoice();
			int roundResult = compareChoices();
			if (roundResult == 0) player1.addWinning();
			if (roundResult == 1) player2.addWinning();
			// Updated score display with consistent colors
			System.out.println(
					ANSI_YELLOW + "Current Score - " +
							ANSI_CYAN + player1.getName() + ": " + player1.getPlayerScore() + ANSI_RESET +
							ANSI_YELLOW + " | " +
							ANSI_MAGENTA + player2.getName() + ": " + player2.getPlayerScore() +
							ANSI_RESET + "\n"
			);
		}
		// Final winner announcement
		if (player1.getPlayerScore() == roundsToWin) {
			System.out.println(ANSI_YELLOW + "********************************");
			System.out.println(ANSI_CYAN + ANSI_BOLD + player1.getName() + " has won the best of " +
					roundsToWin + "!" + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "********************************" + ANSI_RESET);
		} else {
			System.out.println(ANSI_YELLOW + "********************************");
			System.out.println(ANSI_MAGENTA + ANSI_BOLD + player2.getName() + " has won the best of " +
					roundsToWin + "!" + ANSI_RESET);
			System.out.println(ANSI_YELLOW + "********************************" + ANSI_RESET);
		}
	}

	public void modeBotVsBot() {
		generateChoice();
		player1 = new Player("Bot1", 0, "bot");
		player2 = new Player("Bot2", 0, "bot");
	}

	public void modeBotVsPlayer() {
		//set name o player1 to be bot and player2 to be the UserPlayer
		//method to handle user input to play
		//store user choice to further pass it to compare choices
		//make bot player use generate choice
		player1 = new Player("Bot", 0, "bot");
		player2 = new Player("User", 0, "user");
	}

	public void modeUserVsUser() {
		player1 = new Player("User1", 0, "user");
		player2 = new Player("User2", 0, "user");
	}

	public int handlePlayerGame() {
		//better to have user just input a number then writting , like 1-rock, 2-paper, 3-scissors
		int userMove = 0;
		do {
			System.out.println("\nEnter round move:");
			System.out.println("1. Rock");
			System.out.println("2. Paper");
			System.out.println("3. Scissors");
			System.out.print("Your choice (1-3): ");
			try {

				if (userMoveScanner.hasNextInt()) {
					userMove = userMoveScanner.nextInt();
					userMoveScanner.nextLine();//clean scanner

					if (userMove >= 1 && userMove <= 3) {
						userFinalMove = userMove;
						break;
					} else {
						System.out.println("Input a valid option from 1 to 3");
					}
				} else {
					userMoveScanner.nextLine();
					System.out.println("Input a valid move please!");
				}

			} catch (InputMismatchException e) {
				userMoveScanner.nextLine();
				System.out.println("Invalid input, please enter a number!");
			}
		} while (true);
		return userFinalMove;
	}

	public String convertUserMove(int userFinalMove) {
		switch (userFinalMove) {
			case 2: {
				return "paper";
			}
			case 3: {
				return "scissors";
			}
			default: {
				return "rock";
			}
		}
	}
}