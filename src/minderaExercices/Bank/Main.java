package minderaExercices.Bank;

import minderaExercices.Bank.bank.*;

public class Main {
	public static void main(String[] args) {
		Bank bankTest = new Bank();
		bankTest.createCustomer("gabriel","1234");
		CreditAccount creditTest = bankTest.createCreditAccount("1234");
		DebitAccount debitTest = bankTest.createDebitAccount("1234");
		bankTest.askCard(debitTest.getIban(), "1234");
		int creditCardid = bankTest.askCard(creditTest.getIban(), "1234");
		bankTest.deposit(creditCardid, "1234", 100);
	}

	//!add prints to say if money has been deposit like previous balance and newbalance maybe
}
