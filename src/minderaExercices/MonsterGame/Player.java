package minderaExercices.MonsterGame;

import minderaExercices.MonsterGame.Monsters.Monster;

public class Player {

	private static int numberOfInitialCards = 10;
	private int numberOfCardsAlive = numberOfInitialCards;
	private String name;
	private boolean hasLost = false;
	private Monster[] playerCards = new Monster[numberOfInitialCards];

	//this will allow me to not have null index so only alive will be passed and array will always have the needed size
	private int aliveIndexCounter;
	private Monster[] cardsAlive;



	public Player(String name) {
		this.name = name;
	}

	public static int getPlayersCardsLength() {
		return numberOfInitialCards - 1;
	}

	public Monster[] getPlayerCards() {
		return playerCards;
	}

	public Monster[] getCardsAlive() {
		return cardsAlive;
	}

	//use this to random index in random class
	public int getAliveIndexCounter() {
		return aliveIndexCounter;
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

	public void updateAliveCards() {
		//need to create a new one everytime this runs otherwise will not be able to update
		cardsAlive = new Monster[numberOfCardsAlive];
		aliveIndexCounter = 0;

		for (int i = 0; i < playerCards.length; i++) {
			if (!playerCards[i].isDead()) {
				cardsAlive[aliveIndexCounter] = playerCards[i];
				aliveIndexCounter++;
			}
		}
	}
}
