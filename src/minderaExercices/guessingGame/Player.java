package minderaExercices.guessingGame;

public class Player {
	private static Player[] players = new Player[GameSetup.getInitialPlayersNumber()];

	//array that each player will have to store its own guesses this will be initialize in the
	// constructor
	//*now this array size is being set only when a game starts to the current game
	//*range number size that is based on difficulty
	private static int[] playersGuesses;

	//track how many guesses one player has made so it's easier to go inside array of guesses
	private static int guessCount;

	private static int playerCount;

	//this instance is just allowing my players to access the class it self
	//but in the constructor i will ive each player the same 'new' game from gamesetup
	private Game game;

	private String playerName;
	private int winningCounter;

	public Player(int playerId, int playerWinningCount, Game game) {
		//since player id will start at 0 this means player1 will be 0 + 1 ...
		this.game = game;
		this.playerName = "Player" + (playerId + 1);
		this.winningCounter = playerWinningCount;
		guessCount = 0;
		//store each player into the players array to then utilize for turns and score
		players[playerCount] = this;
		playerCount++;
	}

	public static Player[] getPlayers() {
		return players;
	}

	public static void setPlayersGuesses(int playersGuessesSize) {
		playersGuesses = new int[playersGuessesSize];
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public int getWinningCounter() {
		return winningCounter;
	}

	public static int[] getPlayersGuesses() {
		return playersGuesses;
	}

	public int addingWinning() {
		return this.winningCounter++;
	}

	//METHODS DOWN HERE
	//method to handle previous guesses
	private boolean hasGuessedNumber(int guess) {
		for (int i = 0; i < guessCount; i++) {
			if (playersGuesses[i] == guess) {
				return true;
			}
		}
		return false;
	}

	//method to add current guess to the array
	//need t check if there is space to add the new guess
	//void cuz is no return just passing value to the array when rando num is generated
	protected void addGuess(int guess) {
		if (guessCount < playersGuesses.length) {
			playersGuesses[guessCount] = guess;
			guessCount++;
		}
	}

	//i want to be generate number for as long as the current guess already exists in the array
	// of that player
	public int generatePlayerGuess() {
		int playerGuess;
		do {
			playerGuess = (int) (Math.random() * game.getRangeForRandomNumber() + game.getMinRangeForRandomNumber());

		} while (hasGuessedNumber(playerGuess));
		addGuess(playerGuess);
		return playerGuess;
	}

	public void resetPlayerGuesses() {
		playersGuesses = new int[game.getRangeForRandomNumber()];
	}

	public void resetGuessesCount() {
		guessCount = 0;
	}

}
