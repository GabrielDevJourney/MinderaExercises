package minderaExercices.MonsterGame;

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

	//TODO method playRound will be the one to call dealDamage, playRound will also need to check type of monster to
	// pass correct monster to deal
	// damage playRound -> check monster type(that are randomly generated) -> dealDamage -> sufferHit
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
		//todo array tracking attacker rounds monsters id and always compare current id with id in i - 1
		if (checkMonsterType(attackerMonster)) {
			dealDamage(attackerMonster, defenseMonster);
			if (defense.hasPlayerLose()) {
				defense.setHasLost(true);
			}
		}
	}


	private void dealDamage(Monster monsterAttacking, Monster monsterGettingHit) {
		int damageOfHit = monsterAttacking.getDamage();
		monsterGettingHit.sufferHit(damageOfHit);
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


	private Monster generateRandomPick(Player player) {
		int randomIndexToPickFromCards = randomNumberForCardToDeal() - 1;
		return player.getPlayerCards()[randomIndexToPickFromCards];
	}

	//isntead of returning the monster it self i will handle here the check and return if the current mosnter is one
	// that can perform an ability
	private boolean checkMonsterType(Monster monster) {
		if (monster instanceof Vampire vampire) {
			if (vampire.bite()) {
				return true;
			}
		} else if (monster instanceof Mummy mummy) {
			if (//todo crete mummy special condition it will need to return booelan)
			//todo mummy.special
			return true;
		}
		//todo handle null by when calling checkmonster in play round if null then type is warewolf
		//default true means warewolf monster
		return true;
	}

}
