package minderaExercices.RentaShop.basic;

public enum VehicleCatalog {
	//cant isntance class the way i want from here so i need to when populating
	//rent shop array of vehicles create the proper object

	PORSCHE(1, "Porsche Turbo S", 7, "car"),
	DUCATI(2, "Monster 900", 2, "motorcycle");

	//TODO here i can have all the otpion availables
	private int id;
	private int position;
	private String modelName;
	private int gasConsumptionRate;
	private String type;

	private VehicleCatalog(int id, String modelName, int gasConsumptionRate, String type) {
		this.id = id;
		this.modelName = modelName;
		this.gasConsumptionRate = gasConsumptionRate;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getModelName() {
		return modelName;
	}

	public int getGasConsumptionRate() {
		return gasConsumptionRate;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}


	//*MEHTODS

	public void trip(double distance, int time) {

	}

}
