package minderaExercices.Bank.bank;


public abstract class Card {

	//each card will have its own cardid and package must have access
	protected int cardId;

	java.text.DecimalFormat df = new java.text.DecimalFormat("$#,##0.000");

	public String decimalFormatter(double num) {
		return df.format(num);
	}

	public abstract void withdraw(double amount);

	public abstract void deposit(double amount);

	public abstract void payment(double amount);

}
