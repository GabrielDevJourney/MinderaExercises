package minderaExercices.MonsterGame.Monsters;

public class Mummy extends Monster {

	private int repeatedAttacks = 0;

	public Mummy() {
		super();
		health = 120;
		damage = 15;
	}

	public boolean canPlayAgain() {
		return repeatedAttacks != 3;
	}

	//todo will call this everytime its now a mummy playing?
	public void resetReapeadAttacks() {
		repeatedAttacks = 0;
	}
}
