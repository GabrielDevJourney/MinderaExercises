package minderaExercices.Bank.bank;

public abstract class Account {

	 protected int balance;
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

	public int getBalance() {
		return balance;
	}

	public String getOwnerNif() {
		return ownerNif;
	}

	public int[] getCardId() {
		return cardId;
	}

	//*SETTERS

	private void setBalance(int balance) {
		this.balance = balance;
	}

	//*METHODS

	 protected void updateBalance(int amount){
		this.setBalance(amount);
	}

	public void depositMoney(int amountToDeposit){
		balance += amountToDeposit;
	}

	//implement empty method for canPayAmount abstract

	//!generate iban defaut method for both types, must be a easy numeber so when a customer wants to deposit or
	// !withdraw
	//!it will be able to say what account he want to deposit in and if the number is from a credit account it cant
	//!withdraw


	public abstract boolean askCard();






}
