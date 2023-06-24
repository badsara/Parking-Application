package Vehicle;

public class Vehicle {

    private int vehicleID;
    private VehicleType vehicleType;

    public Vehicle(int vehicleID, VehicleType vehicleType) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
    }

    public int getVehicleID() {
        return this.vehicleID;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

}
