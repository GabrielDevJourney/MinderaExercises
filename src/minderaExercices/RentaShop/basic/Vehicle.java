package minderaExercices.RentaShop.basic;

public abstract class Vehicle {
	protected int id;
	protected String modelName;
	protected int gasConsumptionRate;
	protected int maxSpeed;
	protected boolean isRented;
	protected int fuelQuantity = 25;
	protected double fuelCost = 2.5;

	public int getId() {
		return id;
	}

	public String getModelName() {
		return modelName;
	}

	public int getGasConsumptionRate() {
		return gasConsumptionRate;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean rented) {
		isRented = rented;
	}

	public double getFuelCost() {
		return fuelCost;
	}
}
