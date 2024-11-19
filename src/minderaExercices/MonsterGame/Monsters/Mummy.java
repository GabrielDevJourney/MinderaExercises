package minderaExercices.MonsterGame.Monsters;

public class Mummy extends Monster {

	//static so i can reset when other cards are played
	private int repeatedAttacks = 0;
	private int penaltyDamage = 10;

	public Mummy() {
		super();
		health = 120;
		damage = 15;
	}

	public boolean canPlayAgain() {
		return repeatedAttacks != 3;
	}

	public void increaseRepeatedAttacks() {
		repeatedAttacks++;
	}

	public void resetReapeadAttacks() {
		repeatedAttacks = 0;
	}

	public void penaltyDamage() {
		health -= penaltyDamage;
	}
}
