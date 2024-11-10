package minderaExercices.guessingGame;

import java.util.Scanner;

public class GameSetup {
	private static int initialPlayersNumber;
	//instance in gamesetup rather than in players so all will play the same game
	//otherwise each would play its individual game
	private final Game game = new Game();
	private GameScanner scanner;
	private Difficulty difficulty;

	public GameSetup(int initialPlayersNumber) {
		GameSetup.initialPlayersNumber = initialPlayersNumber;
	}

	public static int getInitialPlayersNumber() {
		return initialPlayersNumber;
	}

	//be passing the instance game from gamesetup i make all players be playing the same game
	private static void initializePlayers(int initialPlayersNumber, Game game) {
		for (int i = 0; i < initialPlayersNumber; i++) {
			//create object player with text Player plus current number of iteration eq
			new Player(i, 0, game);
		}
	}

	public void startGame(Difficulty difficulty) {

		//SETTING THE RANGE MIN AND MAX VALUES BASED ON DIFFICULTY MODE
		game.setMinRangeForRandomNumber(difficulty.getMinRange());
		game.setRangeForRandomNumber(difficulty.calculateRange());

		//setting both array of game based on the level choosen
		game.setGameAllRandomNums(difficulty.calculateRange());

		//setting playerguesses size based on difficulty
		Player.setPlayersGuesses(difficulty.calculateRange());

		initializePlayers(this.initialPlayersNumber, game);

		gameLogic(difficulty);
	}

	private void gameLogic(Difficulty difficulty) {

		//need to initialize the fisrt game number so the rounds can really start
		game.generateGameNumber();

		boolean gameWon = false;
		while (!gameWon) {
			playRound(difficulty);
			for (Player player : Player.getPlayers()) {
				if (player.getWinningCounter() == 3) {
					System.out.printf("\033[32m%s has won the game with 3 wins!\033[0m\n", player.getPlayerName());
					gameWon = true;
					break;
				}
			}
		}
	}

	private void playRound(Difficulty difficulty) {

		System.out.printf("\033[41mThe game number range is %s and %s\033[0m\n",
				difficulty.getMinRange(), difficulty.getMaxRange());

		boolean win = false;
		while (!win) {
			for (Player player : Player.getPlayers()) {
				win = player.getPlayerName().equals("Player1") ? handleUserTurn(player, difficulty) :
						handleBotTurn(player);
				if (win) break;
			}
		}
	}

	private boolean isCorrectGuess(int currentPlayerGuess) {
		return currentPlayerGuess == game.getRandomNumberGenerated();
	}

	private boolean handleUserTurn(Player player, Difficulty difficulty) {

		scanner = new GameScanner();
		scanner.handleUserInput(difficulty);

		int userGuess = scanner.getUserFinalChoice();
		player.addGuess(userGuess);
		return handleWin(player, userGuess);
	}

	private boolean handleBotTurn(Player player) {
		int currentPlayerGuess = player.generatePlayerGuess();
		System.out.println("\033[36m" + player.getPlayerName() + " has guessed " + currentPlayerGuess + "\033[0m");
		return handleWin(player, currentPlayerGuess);
	}

	private boolean handleWin(Player player, int currentPlayerGuess) {
		if (isCorrectGuess(currentPlayerGuess)) {
			System.out.printf("\033[34m%s wins this round\033[0m\n",
					player.getPlayerName());
			player.addingWinning();
			player.resetPlayerGuesses();
			player.resetGuessesCount();
			game.generateGameNumber();
			return true;
		}
		return false;
	}
}
