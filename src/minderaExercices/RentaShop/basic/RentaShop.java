/*
package minderaExercices.RentaShop.basic;

public class RentaShop {

	private Vehicle[] vehicles = new Vehicle[2];
	private static int vehicleCounter = 0;

	public RentaShop() {
		populateVehiclesArray();
	}

	//TODO to populate get all enums options and based on their id create the proper object of car or moto
	//todo idea is to populate the array when the rental shop is initialized in MAIN

	public Vehicle[] populateVehiclesArray() {
		for (VehicleCatalog vehicleCatalog : VehicleCatalog.values()) {
			Vehicle vehicle;
			if (vehicleCatalog.getType().equals("car")) {
				vehicle = new Car(vehicleCatalog.getId(), vehicleCatalog.getModelName(),
						vehicleCatalog.getGasConsumptionRate());
			} else if (vehicleCatalog.getType().equals("motorcycle")) {
				vehicle = new Motorcycle(vehicleCatalog.getId(), vehicleCatalog.getModelName(),
						vehicleCatalog.getGasConsumptionRate());
			} else {
				continue;
			}
			vehicles[vehicleCounter] = vehicle;
			vehicleCatalog.setPosition(vehicleCounter);
			vehicleCounter++;
		}
		return vehicles;
	}

	public void rent(VehicleCatalog choice) {
		Vehicle currentVehicle = searchForVehicle(choice);

		//todo i dont need the switch i only need to get enum choice and then change for isRented = true
		if(currentVehicle.isRented()){
			System.out.println("This vehicle is already rented!");
		}
	}
	private Vehicle searchForVehicle(VehicleCatalog choice) {
		for (int i = 0; i < vehicleCounter; i++) {
			if (choice.getId() == vehicles[i].getId()) {
				return vehicles[i];
			}
		}
		return null;
	}

	public void returnVehicle(VehicleCatalog choice) {
		//i want to be able to do rentalShop.returnVehicle(car)
		//check instaceof so it is the correct vehicle if it is
		// check tank quantity = 25 if not charge 2.5euros for liter missing
		//so if currentTank <25 do (25 - currentTank) * 2,5 and print "Amount to play since missing fuel"
		// get that vehicle position to remove it from rented
		// vehicles array
		Vehicle currentVehicle = searchForVehicle(choice);
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getId() == currentVehicle.getId()) {
			}
		}
		//i can crete variable inside the checker
		if (type instanceof Car currentCar) {
			//casting otherwise i can pass type object to another variable
			int currentTankLevel = currentCar.getTankQuantity();
			if (currentTankLevel < 25) {
				int missingFuelQuantity = 25 - currentTankLevel;
				double missingFuelFee = missingFuelQuantity * 2.5;
				System.out.printf("Since you didn't return this car with 25L we need to charge you $%,.2f",
						missingFuelFee);


			} else {
				System.out.println("Thank you for using our services!");
			}
		}

		if (type instanceof Motorcycle currentMotorcycle) {
			//casting otherwise i can pass type object to another variable
			int currentTankLevel = currentMotorcycle.getTankQuantity();
			if (currentTankLevel < 25) {
				int missingFuelQuantity = 25 - currentTankLevel;
				double missingFuelFee = missingFuelQuantity * 2.5;
				System.out.printf("Since you didn't return this car with 25L we need to charge you $%,.2f",
						missingFuelFee);
			} else {
				System.out.println("Thank you for using our services!");
			}
		}
	}
}
*/
