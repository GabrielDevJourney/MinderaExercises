public class Atm {

	Card cardTest = new Card(100,1,123);

	public void method() {
		try {
			cardTest.withdrawFunds(99,1,132);
		} catch (NotEnoughFundsException | NotEnoughPermissonsException e) {
			System.out.println(e.getMessage());
		}
	}
}
