package minderaExercices.Bank.bank;

public class CreditCard extends Card{

	CreditAccount creditAccount;

	//associating the created card with the current account that is creating the card itself
	public CreditCard(CreditAccount creditAccount) {
		this.creditAccount = creditAccount;
	}

	@Override
	public void withdraw(int amount) {
		System.out.println("This card can't be use for withdraw only payments and deposits!");
	}

	@Override
	public void deposit(int amount) {
		int currentBalance = creditAccount.getBalance();
		creditAccount.updateBalance(currentBalance + amount);
	}

	@Override
	public void payment(int amount) {
		int currentBalance = creditAccount.getBalance();
		int finalBalanceAfterPayment = currentBalance - amount;

		if (finalBalanceAfterPayment >= 0) {

			creditAccount.updateBalance(finalBalanceAfterPayment);
		} else {
			if (finalBalanceAfterPayment - creditAccount.getFeeOfUse() >= creditAccount.getMaxDebt()) {

				finalBalanceAfterPayment -= creditAccount.getFeeOfUse();
				creditAccount.updateBalance(finalBalanceAfterPayment);
			} else {
				System.out.println("Not enough funds, please deposit some money to finish this transaction");
			}
		}

	}

}
