public class Card {
	private int funds;
	private final int CARDNUMBER;
	private final int PIN;

	public Card(int funds,int cardNumber, int pin){
		this.funds = funds;
		this.CARDNUMBER = cardNumber;
		this.PIN = pin;
	}

	public void depositFunds(int amount) {
		funds += amount;
	}

	public void withdrawFunds(int amount, int cardNumber, int pin) throws NotEnoughFundsException, NotEnoughPermissonsException {
		if(this.CARDNUMBER != cardNumber || this.PIN != pin){
			throw new NotEnoughPermissonsException("No matching card number and pin");
		}
		if(funds < amount){
			throw new NotEnoughFundsException("Not enough funds!!");
		}
		funds -= amount;
		System.out.println("You now have " + funds + " $");
	}

}
