public class SimpleBear extends Bear {

	public SimpleBear() {
		becomeOutOfBattery();
	}

	public String talk() {
		if (this.battery == 0) {
			return "Simple bear : exhausted he can't talk right now";
		}
		reduceBattery();
		return "Simple bear : I love you";
	}
	//When its batteries are exhausted, it loses its ability to talk.
	//everytime it talks reduce battery

}
