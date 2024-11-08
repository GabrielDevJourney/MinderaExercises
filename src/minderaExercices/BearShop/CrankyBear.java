package minderaExercices.BearShop;

public class CrankyBear extends Bear {

	public CrankyBear() {
		super();
		talkUntilNoBattery();
	}

	public String talk() {
		reduceBattery();
		return willBearSing();
	}

	private String willBearSing() {
		if (battery < 50) {
			battery = 0;
			return """
					Somebody wants you
					Somebody needs you
					Somebody dreams about you every single night
					Somebody can't breathe, without you it's lonely
					Somebody hopes that one day you will see
					That somebody's me.""";
		}
		return "Cranky bear : I love you";
	}

}
