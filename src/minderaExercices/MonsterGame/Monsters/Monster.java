package minderaExercices.MonsterGame.Monsters;

import minderaExercices.MonsterGame.Player;

public abstract class Monster {
	protected String name;
	protected int health;
	protected int damage;
	protected boolean isDead;
	protected int id;
	protected static int idCounter = 0;

	public Monster() {
		this.id = idCounter++;
	}

	//if I need all monsters to have an id this also means that those id must be different with simply incrementing
	// so all will share id this means the current monster id will be last one set ++ this should be incremented in
	// monster, but I can do something like in each monster type this.id = id++

	//*GETTERS AND SETTERS

	public void setDead(boolean dead) {
		isDead = dead;
	}

	public int getHealth() {
		return health;
	}

	public boolean isDead() {
		return isDead;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	//*METHODS

	//using This is referring to the monster that already called method on itself
	public void sufferHit(int damageOfHit, Player currentPlayer) {
		int healthAfterHit = this.getHealth() - damageOfHit;
		this.setHealth(healthAfterHit);
		if (this.getHealth() <= 0) {
			this.setDead(true);
			currentPlayer.decreaseCardsAlive();
			currentPlayer.updateAliveCards();
		}
	}
}
