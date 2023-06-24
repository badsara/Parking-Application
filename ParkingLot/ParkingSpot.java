package ParkingLot;

import Vehicle.Vehicle;
import Vehicle.VehicleType;

public class ParkingSpot {
    private int spotID;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private boolean isAvailable;

    public ParkingSpot(int spotID, VehicleType vehicleType, boolean isAvailable) {
        this.spotID = spotID;
        this.vehicleType = vehicleType;
        this.isAvailable = isAvailable;
    }

    public int getSpotID() {
        return spotID;
    }

    public void setSpotID(int spotID) {
        this.spotID = spotID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
        if(isAvailable) setVehicle(null);
    }
}
