package minderaExercices.Bank.bank;

public class DebitCard extends Card{

	DebitAccount debitAccount;

	//associating the created card with the current account that is creating the card itself
	public DebitCard(DebitAccount debitAccount) {
		this.debitAccount = debitAccount;
	}


	@Override
	public void withdraw(int amountToWithdraw) {
		int currentBalance = debitAccount.getBalance();
		debitAccount.updateBalance(currentBalance - amountToWithdraw);
	}

	@Override
	public void deposit(int amountToDeposit) {
		int currentBalance = debitAccount.getBalance();
		debitAccount.updateBalance(currentBalance + amountToDeposit);
	}


	@Override
	public void payment(int amountToPay){
		int currentBalance = debitAccount.getBalance();

		int possibleNegativeBalance = currentBalance - amountToPay;
		if(currentBalance == 0 || possibleNegativeBalance < 0) {
			System.out.println("Insuficient balance for payment");
			//exit otherwise will do the payment anyway
			return;
		}
		debitAccount.updateBalance(currentBalance - amountToPay);
	}

}
