package minderaExercices.MonsterGame.Monsters;

import minderaExercices.MonsterGame.Random;

public class Vampire extends Monster {

	private int healthBack = 15;

	public Vampire() {
		super();
		health = 100;
		damage = 18;
	}

	//to utilize in game i must return if vampire will bite or not so the action will ocure in game
	public boolean bite() {
		int changeOfBite = Random.generateBiteChange();

		//25% change of biting, also cheking if health is near 85 ensure that health doesn't go above is max health
		if (changeOfBite <= 25 && health <= 85) {
			health += healthBack;
			return true;
		}
		return false;
	}

}
