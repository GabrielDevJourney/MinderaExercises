package minderaExercices.Bank.bank;

public class DebitAccount extends Account{


	//if i create on account will auto create the other otherwise i would bank clas to handle it
	public DebitAccount(){
		super();
		this.cardId = new int[10];
	}

	@Override
	public double getBalance() {
		return balance;
	}


	@Override
	//need to pass the current account to the card to be bale to acess balances
	public boolean askCard() {
		//max amount of debit cards are 10 so if counter bigger then array dont allow more
		if(accountCardIdCounter >= cardId.length){
			System.out.println("Max debit cards reached!!");
			return  false;
		}
		return true;
	}

	public void withdraw(double amount) {
		double possibleNegativeBalance = balance - amount;
		if (balance == 0 || possibleNegativeBalance < 0) {
			System.out.println("Not enough funds to withdraw");
		} else {
			balance -= amount;
		}
	}

	//!canPayAmount override if balance is zero or if it would go below zero and that cant happen

}
