package minderaExercices.BearShop;

public class Bear {

	protected int battery;

	public Bear() {
		this.battery = 100;
	}

	public void reduceBattery() {
		 this.battery =- 25;
	}

	protected void talkUntilNoBattery() {
		while (battery > 0) {
			System.out.println(talk());  // Print the returned String
		}
	}

	public String talk() {
		return "";
	}
	//When its batteries are exhausted, it loses its ability to talk.
	//everytime it talks reduce battery
}
