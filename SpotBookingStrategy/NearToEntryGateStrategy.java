package SpotBookingStrategy;

import Vehicle.Vehicle;

public class NearToEntryGateStrategy implements SpotBookingStrategy {
    @Override
    public void bookParkingSpot(Vehicle vehicle, int entryGateNumber) {
        // calculate distance of each parking spot from entry gate and use
        // priority queue
        System.out.println("Spot Booked near to entry Gate");
    }
}
