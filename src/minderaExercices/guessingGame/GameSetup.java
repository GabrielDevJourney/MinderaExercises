package minderaExercices.guessingGame;

public class GameSetup {
	private static int initialPlayersNumber;
	//instance in gamesetup rather than in players so all will play the same game
	//otherwise each would play its individual game
	private final Game game = new Game();

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

		gameLogic();
	}

	private void gameLogic() {

		//need to initialize the fisrt game number so the rounds can really start
		game.generateGameNumber();

		boolean gameWon = false;
		while (!gameWon) {
			playRound();
			for (Player player : Player.getPlayers()) {
				if (player.getWinningCounter() == 3) {
					System.out.printf("\033[32m%s has won the game with 3 wins!\033[0m\n", player.getPlayerName());
					gameWon = true;
					break;
				}
			}
		}
	}

	private void playRound() {

		System.out.printf("\033[41mThe game number is %s\033[0m\n",
				game.getRandomNumberGenerated());

		boolean win = false;
		while (!win) {
			for (int i = 0; i < Player.getPlayerCount(); i++) {
				//to access each player grab that form the array players
				Player currentPlayer = Player.getPlayers()[i];
				int currentPlayerGuess = currentPlayer.generatePlayerGuess();

				if (isCorrectGuess(currentPlayerGuess)) {
					System.out.printf("\033[34m%s wins this round\033[0m\n",
							currentPlayer.getPlayerName());
					currentPlayer.addingWinning();
					currentPlayer.resetPlayerGuesses();
					currentPlayer.resetGuessesCount();
					game.generateGameNumber();
					win = true;
					break;
				}

			}
		}
	}

	private boolean isCorrectGuess(int currentPlayerGuess) {
		return currentPlayerGuess == game.getRandomNumberGenerated();
	}

}
