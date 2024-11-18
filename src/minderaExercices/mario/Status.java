package minderaExercices.mario;

public enum Status {
	ORDER(5) {
		public boolean isOrdered() {
			printTime();
			return true;
		}
	},
	READY(2) {
		public boolean isReady() {
			printTime();
			return true;
		}
	},
	DELIVERY(0) {
		public boolean isDelivered() {
			printTime();
			return true;
		}
	};

	private int time;

	private Status(int time) {
		this.time = time;
	}

	public boolean isOrdered() {
		return false;
	}

	public boolean isReady() {
		return false;
	}

	public boolean isDelivered() {
		return false;
	}

	public void printTime() {
		System.out.println(this.time);
	}

	//METHOD QUANTO TEMPO FALTA
	//METHOD FOR RETURN EACH SINGLE STATE ORDER READY DELIVERY
}
