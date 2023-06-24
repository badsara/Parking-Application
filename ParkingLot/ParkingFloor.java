package ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorNumber;
    private Map<Integer, ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new HashMap<>();
    }

    private void setParkingSpots(Map<Integer, ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public Map<Integer, ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
