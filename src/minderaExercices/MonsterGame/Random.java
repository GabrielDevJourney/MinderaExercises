package minderaExercices.MonsterGame;

public class Random {

	//change name for generateMonsterType
	public static int generateMonsterType() {
		return (int) (Math.random() * 10 + 1);
	}

	public static int generateBiteChange() {
		return (int) (Math.random() * 100 + 1);
	}

	public static int generateIndex() {
		return (int) (Math.random() * Player.getPlayersCardsLength());
	}

}
