package minderaExercices.Bank.bank;

public class CreditCard extends Card{

	CreditAccount creditAccount;
	private int creditCardCounter;

	//associating the created card with the current account that is creating the card itself
	public CreditCard(CreditAccount creditAccount) {
		this.creditAccount = creditAccount;
		creditCardCounter = 0;
	}

	@Override
	public void depositMoney(int amountToDeposit){
		int currentBalance = creditAccount.getBalance();
		creditAccount.updateBalance(currentBalance + amountToDeposit);
	}

	@Override
	public void payment(int amountToPay){
		int currentBalance = creditAccount.getBalance();
		int possibleBalanceBelowMaxPlanfond = currentBalance - amountToPay - creditAccount.getFeeOfUse();

		if(currentBalance == creditAccount.getMaxDebt() || possibleBalanceBelowMaxPlanfond < creditAccount.getMaxDebt()){
			System.out.println("Not enough planfond to finish payment, please add funds!");
			return;
		}
		creditAccount.updateBalance(currentBalance - amountToPay - creditAccount.getFeeOfUse());
	}

}
