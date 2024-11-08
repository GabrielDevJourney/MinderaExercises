package minderaExercices.BearShop;

public class DrunkBear extends Bear {

	public DrunkBear() {
		super();
		talkUntilNoBattery();
	}

	//Every time it talks, it says "I love you", but it has a 20% probability of falling asleep. When this happens
	// this bear loses its ability to talk, snoring instead.
	public String talk() {
		if (battery == 0) {
			return "Drunk bear: exhausted, can't talk right now";
		}

		int chanceToSleep = probabilityOfFallingSleep();

		reduceBattery();
		if (chanceToSleep >= 0 && chanceToSleep <= 20) {
			return "Drunk bear: Srnnk ... Srnnk ... Srnnk";
		}
		return "Drunk bear: I love you!";
	}

	private int probabilityOfFallingSleep() {
		int change = (int) (Math.random() * 100 + 1);
		return change;
	}
}
