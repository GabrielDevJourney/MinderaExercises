package minderaExercices.Restaurant;

public class Table {
	private boolean free;
	private String order;

	public Table(){
		//set initial state of free = true
		//string to null beacause initially thre is no order
	}

	public void setOrder(String order){
		//set order to the args
	}

	public void getOrder(){
		//get the order from the table
	}

	public void cleanOrder(){
		//this can call the getorder in a table and just put the order as empty but this
		//means it will create a new string since the last one is being "changed"
	}

	public void isFree(){
		//return boolean
		//return whatever might be the boolean state of free propertie
	}

	public void setTableStatus(boolean isFree){
		//set table free based on the isfree that returns the current state of a table freeness
	}

	//?this two methods can be one
	private void occupy(){
		//get the free state and set it to false
	}

	private void unocuppy(){
		//get table free state and set it to true
	}



	private void saveOrder(String order){
		//ask for a order of the client and save it into the table property of order
	}


}
