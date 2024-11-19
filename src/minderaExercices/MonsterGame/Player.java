package minderaExercices.MonsterGame;

import minderaExercices.MonsterGame.Monsters.Monster;

public class Player {

	private static int numberOfInitialCards = 10;
	private int numberOfCardsAlive = numberOfInitialCards;
	private String name;
	private boolean hasLost = false;
	private Monster[] playerCards = new Monster[numberOfInitialCards];

	public Player(String name) {
		this.name = name;
	}

	public static int getPlayersCardsLength() {
		return numberOfInitialCards - 1;
	}

	public Monster[] getPlayerCards() {
		return playerCards;
	}

	public int getNumberOfCardsAlive() {
		return numberOfCardsAlive;
	}

	public String getName() {
		return name;
	}

	public void setHasLost(boolean hasLost) {
		this.hasLost = hasLost;
	}

	public void decreaseCardsAlive() {
		numberOfCardsAlive--;
	}

	public boolean hasNoCards() {
		if (numberOfCardsAlive == 0) {
			return true;
		}
		return false;
	}
}
