package minderaExercices.Bank.bank;

public class CreditAccount extends Account{

	private int numberOfCreditCards;
	private int feeOfUse = 10;
	private int maxDebt = -150;

	public CreditAccount() {
		super();
		this.cardId = new int[1];
		this.numberOfCreditCards = 0;
	}

	public int getBalance() {
		return balance;
	}


	public int getFeeOfUse() {
		return feeOfUse;
	}

	public int getMaxDebt() {
		return maxDebt;
	}

	//!method to see if there is money to pay this means if when payment is to be done
	//!if the amount + fee will make balance go below debt max -150

	@Override
	//since i cant return a null card that would be bad beacause later i could wrongly try to access credit card
	//always check if card is returning null when called so it will trow error
	public boolean askCard() {
		if(numberOfCreditCards == 1) {
			System.out.println("Can't give you more cards you already have one");
			return false;
		}
		//card will be created in bank here i will just check if its possible
		numberOfCreditCards ++;
		return true;
	}
}
