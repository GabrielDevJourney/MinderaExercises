package minderaExercices.Blackjack;

public class Game {
	// ANSI color codes
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private Blackjack blackjack;
	protected Player dealer;
	protected Player player1;
	private int finalScore = 21;

	public Game() {
		blackjack = new Blackjack();
		initializePlayers();
	}

	public void initializePlayers() {
		dealer = new Player("Dealer");
		player1 = new Player("Player1");
	}

	public void startGame() {
		System.out.println(ANSI_PURPLE + "\n=== Blackjack Game Started ===" + ANSI_RESET);
		while (!isGameOver()) {
			playTurn(dealer);

			if (!isGameOver()) {
				playTurn(player1);
			}
		}
		announceWinner();
	}

	private boolean isGameOver() {
		return dealer.getPlayerScore() >= finalScore || player1.getPlayerScore() >= finalScore;
	}

	private void playTurn(Player player) {
		Card currentCard = blackjack.dealCard();
		sumScore(currentCard,player);
		displayTurnInfo(player, currentCard);
	}
	private void sumScore(Card currentCard, Player player){
		int value;
			switch (currentCard.getSymbol()) {
				case "A":
					if (player.getPlayerScore() <= 10) {
						value = 11;
					}else{
						value = 1;
					}
				case "K", "Q", "J":
					value = 10;
					break;
				default:
					// this parse will work since i am previously safe guarding all possible case scenarios
					value = Integer.parseInt(currentCard.getSymbol());
					break;
			}
		player.sumCards(value);
	}
	private void displayTurnInfo(Player player, Card card) {

		String playerColor = player.getPlayerName().equals("Dealer") ? ANSI_BLUE : ANSI_GREEN;

		System.out.println(playerColor + player.getPlayerName() + ANSI_RESET + " drew " +
				ANSI_YELLOW + card.getCardName() + ANSI_RESET +
				". Total: " + playerColor + player.getPlayerScore() + ANSI_RESET);
	}

	private void announceWinner() {
		System.out.println(ANSI_PURPLE + "\n=== Game Over! ===" + ANSI_RESET);
		playersFinalScore();
		winnerAndAnnounceIt();
	}

	private void playersFinalScore() {
		System.out.println(ANSI_BLUE + dealer.getPlayerName() + "'s final score: " +
				dealer.getPlayerScore() + ANSI_RESET);
		System.out.println(ANSI_GREEN + player1.getPlayerName() + "'s final score: " +
				player1.getPlayerScore() + ANSI_RESET);
	}

	private void winnerAndAnnounceIt() {
		int dealerScore = dealer.getPlayerScore();
		int player1Score = player1.getPlayerScore();

		System.out.println(ANSI_YELLOW + "\nFinal Result:" + ANSI_RESET);

		if (areBothPlayersBust(dealerScore, player1Score)) {

			System.out.println(ANSI_RED + "Both players bust! No winner!" + ANSI_RESET);

		} else if (isPlayerBust(dealerScore)) {

			System.out.println(ANSI_GREEN + player1.getPlayerName() + " wins!" + ANSI_RESET +
					ANSI_RED + " " + dealer.getPlayerName() + " bust!" + ANSI_RESET);

		} else if (isPlayerBust(player1Score)) {

			System.out.println(ANSI_BLUE + dealer.getPlayerName() + " wins!" + ANSI_RESET +
					ANSI_RED + " " + player1.getPlayerName() + " bust!" + ANSI_RESET);

		} else if (hasBlackjack(dealerScore)) {

			System.out.println(ANSI_BLUE + dealer.getPlayerName() + " wins with Blackjack!" + ANSI_RESET);

		} else if (hasBlackjack(player1Score)) {

			System.out.println(ANSI_GREEN + player1.getPlayerName() + " wins with Blackjack!" + ANSI_RESET);

		}
	}

	//Checking all possible ways a game can go, both brust, one brust or one wins
	private boolean areBothPlayersBust(int dealerScore, int player1Score) {
		return dealerScore > finalScore && player1Score > finalScore;
	}

	private boolean isPlayerBust(int score) {
		return score > finalScore;
	}

	private boolean hasBlackjack(int score) {
		return score == finalScore;
	}
}
