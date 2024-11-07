public class Bear {
	protected int battery;

	public Bear() {
		this.battery = 100;
	}

	protected int reduceBattery() {
		return this.battery -= 25;
	}

	protected void becomeOutOfBattery() {
		while (this.battery > 0) {
			System.out.println(talk());  // Print the returned String
		}
	}

	public String talk() {
		return "I LOVE YOU";
	}
	//When its batteries are exhausted, it loses its ability to talk.
	//everytime it talks reduce battery
}
