package minderaExercices.experiments.carExerciseOOP;

public class Tire {
	private int integrity;
	private int tearRate;
	private int tireId;
	private String tireName;

	public Tire(int tireId) {
		this.integrity = 100;
		this.tireId = tireId;
		System.out.println(this.tireId);
		this.tireName = "Tire" + (tireId + 1);
		//make each tire has a different tire rate
		switch(tireId) {
			case 0: // Front left
				this.tearRate = 3;
				break;
			case 1: // Front right
				this.tearRate = 2;
				break;
			case 2: // Back left
				this.tearRate = 1;
				break;
			case 3: // Back right
				this.tearRate = 2;
				break;
			default:
				this.tearRate = 2;
		}
	}

	//GETTERS AND SETTERS

	public String getTireName() {
		return tireName;
	}

	public int getIntegrity() {
		return integrity;
	}
	public void setIntegrity(){
		integrity = 100;
	}

	//METHODS
	public void removeIntegrity(){
		integrity -= tearRate;
		if(integrity < 0){
			integrity = 0;
		}
		System.out.println(tireName + " integrity: " + integrity + "%");
	}
	public boolean explode(){
		//if integrity reaches 0 then print "tire has exploded"
		return integrity == 0;
	}
}
