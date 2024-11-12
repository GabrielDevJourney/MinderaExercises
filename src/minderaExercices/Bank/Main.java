package minderaExercices.Bank;

import minderaExercices.Bank.bank.Bank;
import minderaExercices.Bank.bank.CreditAccount;
import minderaExercices.Bank.bank.DebitAccount;
import minderaExercices.Bank.bank.DebitCard;

public class Main {
	public static void main(String[] args) {
		Bank bankTest = new Bank();
		bankTest.createCustomer("gabriel","1234");
		CreditAccount creditTest = bankTest.createCreditAccount("1234");
		DebitAccount debitTest = bankTest.createDebitAccount("1234");
		bankTest.askCard(debitTest.getIban(), "1234");
		bankTest.askCard(creditTest.getIban(), "1234");

		bankTest.createCustomer("cris","231");
		CreditAccount creditTest2 = bankTest.createCreditAccount("231");
		DebitAccount debitTest2 = bankTest.createDebitAccount("231");
		bankTest.askCard(debitTest2.getIban(), "231");
		bankTest.askCard(creditTest2.getIban(), "231");


		//!!must spit the new account iban that will be generated with ++ from to 0 - infinty


		//?? always check for size of arrays cardNumbers and accounts and see if the counter that i use to
		//?? go trough them is bigger then the arrays length
		//!bank.askCard(accountIban)
			//!go to all bank accts, check which account id matchs with the accountIban if there are any
			//! generate newCardId can be a counter ++
			//! then go to the account cardId and add to it based on THIS account cardIdCounter
			//! everytime i want to add a new cardid i can simply go to cardId[cardIdCounter]
			//!spit card number id

		//!bank.widhdraw(cardNumberId, amount)
			//!go to all account find an account that within his cardId array has that card number
			//! get that account balance and subtract amount passed trough the method

	}
}
