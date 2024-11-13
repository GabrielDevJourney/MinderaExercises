package minderaExercices.Bank.bank;

public abstract class Card {

	//each card will have its own cardid and package must have access
	protected int cardId;

	public abstract void withdraw(int amount);

	public abstract void deposit(int amount);

	public abstract void payment(int amount);

}
