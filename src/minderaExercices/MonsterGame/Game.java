package minderaExercices.MonsterGame;

import minderaExercices.MonsterGame.Monsters.Monster;
import minderaExercices.MonsterGame.Monsters.Mummy;
import minderaExercices.MonsterGame.Monsters.Vampire;
import minderaExercices.MonsterGame.Monsters.Warewolf;

public class Game {
	//trying to use last class subject since players will always be 2 why not set it
	private final Player[] players = new Player[2];
	private int roundTrackingCounter = 0;

	public Game() {
		this.players[0] = new Player("Player 1");
		this.players[1] = new Player("Player 2");
		initializePlayersHands();
	}

	//*METHODS

	private void initializePlayersHands() {
		for (Player player : players) {
			dealCards(player);
		}
	}

	private void playRound() {
		Player player1 = players[0];
		Player player2 = players[1];

		//keep playing while neither has lost all cards so have a variable for both
		while (!player1.hasPlayerLose() && !player2.hasPlayerLose()) {

			Monster monsterPlayer1 = generateRandomPick(player1);
			Monster monsterPlayer2 = generateRandomPick(player2);

			if (roundTrackingCounter % 2 == 0) {
				//generate here to always pick diferent monster
				handleTurn(player1, player2, monsterPlayer1, monsterPlayer2);
			} else {
				handleTurn(player2, player1, monsterPlayer2, monsterPlayer1);
			}
			roundTrackingCounter++;
		}

	}

	private void handleTurn(Player attacker, Player defense, Monster attackerMonster, Monster defenseMonster) {
		if (checkMonsterType(attackerMonster)) {
			dealDamage(attackerMonster, defenseMonster, defense);
			if (defense.hasPlayerLose()) {
				defense.setHasLost(true);
			}
		}
	}


	private void dealDamage(Monster monsterAttacking, Monster monsterGettingHit, Player defense) {
		int damageOfHit = monsterAttacking.getDamage();
		monsterGettingHit.sufferHit(damageOfHit, defense);
	}

	private void dealCards(Player player) {
		Monster[] currentPlayerHand = player.getPlayerCards();
		for (int i = 0; i < currentPlayerHand.length; i++) {
			if (currentPlayerHand[i] == null) {
				currentPlayerHand[i] = generateRandomCardToDeal();
			}
		}
	}

	//* HELPER FUNCTIONS

	//change of mummy/vampire 40% warewolf 20% duo to stronger and tanky traits
	private Monster generateRandomCardToDeal() {
		int randomNumberToDealCard = randomNumberForCardToDeal();

		if (randomNumberToDealCard <= 2) {
			return new Warewolf();
			//will go to next since num is above 3 no need for &&
		} else if (randomNumberToDealCard <= 6) return new Mummy();
		return new Vampire();
	}


	//this will be used for both randomize dealing and selecting player move
	private int randomNumberForCardToDeal() {
		return (int) (Math.random() * 10 + 1);
	}


	//if monster picked is dead i must pick another one this means calling the generateRandomPick again
	private Monster generateRandomPick(Player player) {
		// 0 - 9 indexs
		Monster[] currentPlayerCards = player.getPlayerCards();
		int numberOfAttempts = 0;

		int randomIndexToPickFromCards = randomNumberForCardToDeal() - 1;
		Monster currentMonster = currentPlayerCards[randomIndexToPickFromCards];

		//first check if the mosnter is dead it is lets go to the while loop then
		if (!currentMonster.isDead()) {
			return currentMonster;
		}

		//do while will numberof attemps is less then half te whole cards
		while (numberOfAttempts < currentPlayerCards.length / 2) {
			//generate new position and see if that is not dead
			int newRandomIndex = randomNumberForCardToDeal() - 1;
			Monster newMonster = currentPlayerCards[newRandomIndex];

			if (!newMonster.isDead()) {
				return newMonster;
			}
			numberOfAttempts++;
		}


		//not able to find randomly then return first alive monster
		for (int i = 0; i < currentPlayerCards.length; i++) {
			if (!currentPlayerCards[i].isDead()) {
				return currentPlayerCards[i];
			}
		}

		//none alive then that player has lost
		System.out.printf(player.getName() + " has lost no more cards alive");
		return null;
	}


	//isntead of returning the monster it self i will handle here the check and return if the current mosnter is one
	// that can perform an ability
	private boolean checkMonsterType(Monster monster) {
		if (monster instanceof Vampire vampire) {
			if (vampire.bite()) {
				return true;
			}
		} else if (monster instanceof Mummy mummy) {
			if (mummy.canPlayAgain()) return true;
			return false;
		}
		return true;
	}

}
