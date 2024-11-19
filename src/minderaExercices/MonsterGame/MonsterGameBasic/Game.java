package minderaExercices.MonsterGame.MonsterGameBasic;

import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Monster;
import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Mummy;
import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Vampire;
import minderaExercices.MonsterGame.MonsterGameBasic.Monsters.Werewolf;

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
			//initialize cardsAlive with all new cards
			player.updateAliveCards();
		}
	}

	public void start() {
		playGame();
	}

	private void playGame() {
		Player player1 = players[0];
		Player player2 = players[1];

		//keep playing while neither has lost all cards so have a variable for both
		while (!player1.hasNoCards() && !player2.hasNoCards()) {

			playRound(player1, player2);
			roundTrackingCounter++;
		}

		endGame(player1, player2);

	}

	private void playRound(Player player1, Player player2) {

		Monster monsterPlayer1 = generateRandomRoundPick(player1);
		Monster monsterPlayer2 = generateRandomRoundPick(player2);


		if (roundTrackingCounter % 2 == 0) {
			//generate here to always pick different monster

			//!terminal
			System.out.println("\nRound " + roundTrackingCounter);

			System.out.println(player1.getName() + " is attacking and " + player2.getName() + " is being attacked!");

			System.out.println(player1.getName() + "'s monster: " + monsterPlayer1.getName() +
					" (HP: " + monsterPlayer1.getHealth() + ")");
			System.out.println(player2.getName() + "'s monster: " + monsterPlayer2.getName() +
					" (HP: " + monsterPlayer2.getHealth() + ")");

			//!terminal

			handleTurn(player2, monsterPlayer1, monsterPlayer2);
		} else {

			//!terminal

			System.out.println("\nRound " + roundTrackingCounter);
			System.out.println(player2.getName() + " is attacking and " + player1.getName() + " is being attacked!");

			System.out.println(player1.getName() + "'s monster: " + monsterPlayer1.getName() +
					" (HP: " + monsterPlayer1.getHealth() + ")");
			System.out.println(player2.getName() + "'s monster: " + monsterPlayer2.getName() +
					" (HP: " + monsterPlayer2.getHealth() + ")");

			//!terminal

			handleTurn(player1, monsterPlayer2, monsterPlayer1);
		}

	}

	private void endGame(Player player1, Player player2) {
		if (player1.isHasLost()) {
			System.out.printf(player1.getName() + " has lost! " + player2.getName() + " wins!");
		} else {
			System.out.printf(player2.getName() + " has lost! " + player1.getName() + " wins!");
		}
	}


	//no need for attacker player itself be passed since I am passing his selected monster and that is where i will
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

		//!terminal
		System.out.println("Damage dealt to " + monsterGettingHit.getName() + " " + damageOfHit + " damage");
		System.out.println(monsterGettingHit.getName() + " health after hit: " + monsterGettingHit.getHealth());
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

	//change of mummy/vampire 40% werewolf 20% duo to stronger and tank traits
	private Monster generateRandomDealCard() {
		int randomNumberToDealCard = Random.generateMonsterType();

		if (randomNumberToDealCard <= 2) {
			return new Werewolf();
			//will go to next since num is above 3 no need for &&
		} else if (randomNumberToDealCard <= 6) return new Mummy();
		return new Vampire();
	}


	//if monster picked is dead I must pick another one this means calling the generateRandomRoundPick again
	private Monster generateRandomRoundPick(Player player) {
		int randomIndex = Random.generateIndex(player);

		if (player.getCardsAlive() == null) {
			player.updateAliveCards();
		}

		Monster[] currentPlayerCards = player.getCardsAlive();
		return currentPlayerCards[randomIndex];

	}


	//check first mummy other wise i would no be able to reset its repeatedAttacksCounter because of access and scope
	// problem since casted mummy inst accessible to other instance of monster
	//todo make this to be a responsibility of each monster itself
	private boolean checkMonsterType(Monster monster) {
		if (monster instanceof Mummy mummy) {
			if (mummy.canPlayAgain()) {
				mummy.increaseRepeatedAttacks();
				return true;
			}
			mummy.penaltyDamage();
			mummy.resetRepeatedAttacks();
			return false;
		} else if (monster instanceof Vampire vampire) {
			vampire.bite();
			return true;
		}
		return true;
	}
}
