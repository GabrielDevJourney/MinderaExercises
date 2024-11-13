package minderaExercices.Bank.bank;

public class DebitCard extends Card{

	DebitAccount debitAccount;

	//associating the created card with the current account that is creating the card itself
	public DebitCard(DebitAccount debitAccount) {
		this.debitAccount = debitAccount;
	}


	@Override
	public void withdraw(double amount) {
		double currentBalance = debitAccount.getBalance();
		double newBalance = currentBalance - amount;
		debitAccount.updateBalance(newBalance);
		System.out.println("Previous balance was " + decimalFormatter(currentBalance) + " after withdraw you have " + decimalFormatter(newBalance));
	}

	@Override
	public void deposit(double amount) {
		double currentBalance = debitAccount.getBalance();
		double newBalance = currentBalance + amount;
		debitAccount.updateBalance(newBalance);
		System.out.println("Previous balance was " + decimalFormatter(currentBalance) + " after deposit you have " + decimalFormatter(newBalance));
	}


	@Override
	public void payment(double amount) {
		double currentBalance = debitAccount.getBalance();
		double newBalance = currentBalance - amount;

		if (currentBalance == 0 || newBalance < 0) {
			System.out.println("Insuficient balance for payment");
			//exit otherwise will do the payment anyway
			return;
		}
		debitAccount.updateBalance(newBalance);
		System.out.println("Previous balance was " + decimalFormatter(currentBalance) + " after payment you have " + decimalFormatter(newBalance));
	}

}
