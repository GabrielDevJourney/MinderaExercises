public class CrankyBear extends Bear {
	private boolean hasSang = false;

	public CrankyBear() {
		becomeOutOfBattery();
	}

	public String talk() {
		reduceBattery();
		return willBearSing();
	}

	private String willBearSing() {
		if (this.battery < 50) {
			hasSang = true;
			this.battery = 0;
			return "Somebody wants you\n" +
					"Somebody needs you\n" +
					"Somebody dreams about you every single night\n" +
					"Somebody can't breathe, without you it's lonely\n" +
					"Somebody hopes that one day you will see\n" +
					"That somebody's me.\n" +
					"\n";
		}
		return "Cranky bear : I love you";
	}

}
