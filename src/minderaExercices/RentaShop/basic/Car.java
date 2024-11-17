package minderaExercices.RentaShop.basic;

public class Car extends Vehicle {

	public Car(int id, String modelName, int gasConsumptionRate) {
		this.id = id;
		this.modelName = modelName;
		this.gasConsumptionRate = gasConsumptionRate;//5 liter per kil
		this.maxSpeed = 120;
		this.isRented = false;
	}

	//todo should time be passed in 1,5 meaning 1h30min but be converted or type of data will be somehow already
	//todo asking for a time type
	public void trip(double distance, int time) {
		//he trip cannot be performed if:
		//- The necessary speed is higher than the maximum speed
		//so get that by doing distance / time should be a double
		//compare vehicle max speed with previous value
		//- There is not enough gas for the distance
		//use consumption, check how much kil can he do in current fuel this would be
		// tankQuantity/gasConsumptionRate if this is lower then distance cant do trip without refuel
		//refuel will be done when tankQuantity reaches one consumption way from tankQuantity becoming 0
		//Otherwise, the trip will result in reducing the available fuel (according to its gas consumption value).
	}
}
