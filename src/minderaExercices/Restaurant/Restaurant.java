package minderaExercices.Restaurant;

public class Restaurant {
	private Client[] clients;
	private Table[] tables;
	private boolean fullCapacity;
	private int numberOfTablesOccupied;

	public Restaurant(/* pass number of tables to be able to set a size for the tables array*/){
		//initial state of the restaurant
		//clients can be the same size of table array since each table is only associated to one client
	}

	private void findTable(){
		//check in the tables array for each table which is the firt to appear free = true
	}

	//i would need to also associate the table to the client

	private void freeTable(){
		//set table free = true this might becalled in find table to check table state maybe but for that i have
		// isFree in table class
		//!this method doesnt make a lot of sense i can call setFreeTable to change state
	}

	private void receiveOrder(){
		//this will setorder for that table based on what the method setorder is passing
	}

	//?might need method to say that order has been completed and clean and set table to free
	private void checkIfTableCanBeFreed(){
		//if order of that table has been cleaned
		//is unoccupy
		//call freeTable to set free in that table to true
	}

	private void occupyTable(){
		//call the occupy from table to set free to false
		//!also redundant i can simply call isfree or something to make the table be occupied
	}


}
