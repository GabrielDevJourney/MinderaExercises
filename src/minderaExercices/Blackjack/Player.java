package minderaExercices.Blackjack;

public class Player {

	private int playerScore;
	private String playerName;

	public Player(String playerName) {
		this.playerScore = 0;
		this.playerName = playerName;
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public String getPlayerName() {
		return playerName;
	}

	public int sumCards(Card currentPlayerCard) {
		return this.playerScore += currentPlayerCard.getValueOfCard();
	}
}
