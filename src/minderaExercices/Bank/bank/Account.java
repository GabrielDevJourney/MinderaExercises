package minderaExercices.Bank.bank;

public abstract class Account {

	protected double balance;
	 protected int iban;
	 protected String ownerNif;
	 protected int[] cardId;
	 protected int accountCardIdCounter = 0;

	public Account() {
		this.balance = 0;
		//each account will have one of each type

	}

	//*GETTERS
	public int getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	public String getOwnerNif() {
		return ownerNif;
	}

	public int[] getCardId() {
		return cardId;
	}

	//*SETTERS

	private void setBalance(double balance) {
		this.balance = balance;
	}

	//*METHODS

	protected void updateBalance(double amount) {
		this.setBalance(amount);
	}

	public abstract boolean askCard();






}
