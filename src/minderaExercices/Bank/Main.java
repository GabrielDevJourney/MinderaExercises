package minderaExercices.Bank;

import minderaExercices.Bank.bank.*;

public class Main {
	public static void main(String[] args) {
		Bank bankTest = new Bank();

		bankTest.createCustomer("gabriel","1234");

		//since i have that customer already on the list it will not create a new object and pass it to array because
		// alrady exists so supposedly ignores
		bankTest.createCustomer("cris", "1234");

		CreditAccount creditTest = bankTest.createCreditAccount("1234");

		CreditAccount creditTest2 = bankTest.createCreditAccount("1234");
		DebitAccount debitTest = bankTest.createDebitAccount("1234");


		//bankTest.askCard(debitTest.getIban(), "1234");

		//store cardIdFrom the created card
		/*int creditCardid = bankTest.askCard(creditTest.getIban(), "1234");
		bankTest.deposit(creditCardid, "1234", 550.56);
		bankTest.pay(creditCardid, "1234",551);
		bankTest.withdraw(creditCardid, "1234", 142);

		 int debitcard = bankTest.askCard(debitTest.getIban(),"1234");
		 bankTest.deposit(debitcard,"1234",532.12);
		 bankTest.pay(debitcard, "1234",231.23);
		 bankTest.withdraw(debitcard, "1234", 122);*/
	}

}
