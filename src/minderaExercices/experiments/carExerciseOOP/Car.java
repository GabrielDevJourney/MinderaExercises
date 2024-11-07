package minderaExercices.experiments.carExerciseOOP;

public class Car {
	Radio radio;
	private Tire[] tires;
	private boolean isMoving;

	public Car(){
		this.tires = new Tire[4];
		this.radio = new Radio();
		this.isMoving = true;
		for(int i = 0; i < tires.length; i++) {
			tires[i] = new Tire(i);
		}
	}


	//METHODS
	public void move(){
		if(!isMoving){
			System.out.println("Car can't move check tires");
			return;
		}
		for(Tire tire : tires) {

			if (tire.getIntegrity() > 0) {
				tire.removeIntegrity();
				if (tire.explode()) {
					isMoving = false;
					System.out.println(tire.getTireName() + " has exploded!");
					radio.play();
					changeTire(tire);
				}
			}
			//this is for not letting the for continue to the other tires
			break;
		}
	}

	//call when wanting to change the state of moving of car to false

	//now i have to change tire based on each tire within tires array since this will be called for
	//the tire that exploded and not for all
	public void changeTire(Tire tire) {
		//now i am changing the tier only for the tire that has exploded
		System.out.println(tire.getTireName() + " has been changed");
		tire.setIntegrity();
	}

	public void startDriving() {
		while (isMoving) {
			this.move();
		}
}

}


