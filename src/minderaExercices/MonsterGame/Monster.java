package minderaExercices.MonsterGame;

public abstract class Monster {
	protected int health;
	protected int damage;
	protected boolean isDead;
	protected int id;
	protected static int idCounter = 0;

	public Monster() {
		this.id = idCounter++;
	}

	//if i need all monsters to have an id this also means that those id must be different with symply incrementeing
	// so all will share id this means the current monster id will be last one set ++ this should be incremented in
	// mosnter but i can do something like in each each monster type this.id = id++

	//*GETTERS AND SETTERS

	public void setDead(boolean dead) {
		isDead = dead;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	//*METHODS

	//using This is refereing to the monster that already called method on itself
	public void sufferHit(int damageOfHit) {
		int healthAfterHit = this.getHealth() - damageOfHit;
		this.setHealth(healthAfterHit);
		if (this.getHealth() <= 0) {
			this.setDead(true);
		}
	}


}