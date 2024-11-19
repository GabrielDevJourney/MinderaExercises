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

	//todo change to play game and maybe separate things and have the while logic in a method
	private void playRound() {
		Player player1 = players[0];
		Player player2 = players[1];

		//keep playing while neither has lost all cards so have a variable for both
		while (!player1.hasNoCards() && !player2.hasNoCards()) {

			Monster monsterPlayer1 = generateRandomRoundPick(player1);
			Monster monsterPlayer2 = generateRandomRoundPick(player2);

			if (roundTrackingCounter % 2 == 0) {
				//generate here to always pick diferent monster
				handleTurn(player2, monsterPlayer1, monsterPlayer2);
			} else {
				handleTurn(player1, monsterPlayer2, monsterPlayer1);
			}
			roundTrackingCounter++;
		}

	}

	//no need for attacker player itself be passed since i am passing his selected monster and that is where i will
	// grab damage to deal from
	private void handleTurn(Player defense, Monster attackerMonster, Monster defenseMonster) {
		if (checkMonsterType(attackerMonster)) {
			dealDamage(attackerMonster, defenseMonster, defense);
			if (defense.hasNoCards()) {
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
				currentPlayerHand[i] = generateRandomDealCard();
			}
		}
	}

	//* HELPER FUNCTIONS

	//change of mummy/vampire 40% warewolf 20% duo to stronger and tanky traits
	private Monster generateRandomDealCard() {
		int randomNumberToDealCard = Random.generateMonsterType();

		if (randomNumberToDealCard <= 2) {
			return new Warewolf();
			//will go to next since num is above 3 no need for &&
		} else if (randomNumberToDealCard <= 6) return new Mummy();
		return new Vampire();
	}


	//if monster picked is dead i must pick another one this means calling the generateRandomRoundPick again
	private Monster generateRandomRoundPick(Player player) {
		// 0 - 9 indexs
		Monster[] currentPlayerCards = player.getPlayerCards();
		int numberOfAttempts = 0;

		//todo change max random number to be array size
		int randomIndexToPickFromCards = Random.generateIndex();
		Monster currentMonster = currentPlayerCards[randomIndexToPickFromCards];

		//first check if the mosnter is dead it is lets go to the while loop then
		if (!currentMonster.isDead()) {
			return currentMonster;
		}

		//do while will numberof attemps is less then half te whole cards
		while (numberOfAttempts < currentPlayerCards.length / 2) {
			//generate new position and see if that is not dead
			int newRandomIndex = Random.generateIndex();
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


	//check first mummy other wise i would no be able to reset its repeatedAttacksCounter because of access and scole
	// problem since casted mummy inst accessible to other instance of monster
	private boolean checkMonsterType(Monster monster) {
		if (monster instanceof Mummy mummy) {
			if (mummy.canPlayAgain()) {
				mummy.increaseRepeatedAttacks();
				return true;
			}
			mummy.penaltyDamage();
			mummy.resetReapeadAttacks();
			return false;
		} else if (monster instanceof Vampire vampire) {
			vampire.bite();
			return true;
		}
		return true;
	}
}
