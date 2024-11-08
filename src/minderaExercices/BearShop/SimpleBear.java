package minderaExercices.BearShop;

public class SimpleBear extends Bear {


	public SimpleBear() {
		super();
		talkUntilNoBattery();
	}

	public String talk() {
		if (battery == 0) {
			return "Simple bear : exhausted he can't talk right now";
		}
		reduceBattery();
		return "Simple bear : I love you";
	}
	//When its batteries are exhausted, it loses its ability to talk.
	//everytime it talks reduce battery

}
