package minderaExercices.BearShop;

public class Shop {
	private int bearCounter;
	private String name;

	public Shop(String name) {
		bearCounter = 0;
		this.name = name;
	}

	public int getBearCounter() {
		return bearCounter;
	}

	public String getName() {
		return name;
	}

	public Bear createBears() {
		if (bearCounter % 5 == 0) {
			increaseCounting();
			return new CrankyBear();
		} else if (bearCounter % 2 == 0) {
			increaseCounting();
			return new SimpleBear();
		}
		increaseCounting();
		return new DrunkBear();
	}

	protected void increaseCounting() {
		 this.bearCounter++;
	}

	public String compareToOtherStore(Shop otherShop) {
		return (this.getBearCounter() > otherShop.getBearCounter()) ?
				this.getName() + " has won with " + this.getBearCounter() + " bears" :
				otherShop.getName() + " has won with " + otherShop.getBearCounter() + " bears";
	}
}
