package minderaExercices.Bank.bank;

public class CreditCard extends Card {

	CreditAccount creditAccount;

	//associating the created card with the current account that is creating the card itself
	public CreditCard(CreditAccount creditAccount) {
		this.creditAccount = creditAccount;
	}

	@Override
	public void withdraw(double amount) {
		System.out.println("This card can't be use for withdraw only payments and deposits!");
	}

	@Override
	public void deposit(double amount) {
		double currentBalance = creditAccount.getBalance();
		double newBalance = currentBalance + amount;
		creditAccount.updateBalance(newBalance);

		System.out.println("Your previous balance was " + decimalFormatter(currentBalance) + " after deposit " +
				"is " + decimalFormatter(newBalance));
	}

	@Override
	public void payment(double amount) {

		double currentBalance = creditAccount.getBalance();
		double finalBalanceAfterPayment = currentBalance - amount;

		if (finalBalanceAfterPayment >= 0) {
			creditAccount.updateBalance(finalBalanceAfterPayment);
			System.out.print("Your previous balance was " + decimalFormatter(currentBalance) + " after " +
					"payment" + "is " + decimalFormatter(finalBalanceAfterPayment));

		} else {
			if (finalBalanceAfterPayment - creditAccount.getFeeOfUse() >= creditAccount.getMaxDebt()) {

				finalBalanceAfterPayment -= creditAccount.getFeeOfUse();
				creditAccount.updateBalance(finalBalanceAfterPayment);
			} else {
				System.out.println("Not enough funds, please deposit some money to finish this transaction");
			}
			System.out.println("Your previous balance was " + decimalFormatter(currentBalance) + " after " +
					"payment" +
					" " +
					"is " + decimalFormatter(finalBalanceAfterPayment));
		}

	}

}
