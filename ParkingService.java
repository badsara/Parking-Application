import ParkingLot.ParkingLot;
import SpotBookingStrategy.SpotBookingStrategy;
import Ticket.Ticket;
import Vehicle.Vehicle;
import ParkingLot.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ParkingService {
    private Random random = new Random();
    private ParkingLot parkingLot;
    private Map<Integer, Ticket> tickets;
    private SpotBookingStrategy spotBookingStrategy;

    public ParkingService(ParkingLot parkingLot, SpotBookingStrategy spotBookingStrategy) {
        this.parkingLot = parkingLot;
        this.spotBookingStrategy = spotBookingStrategy;
        this.tickets = new HashMap<>();
    }

    public Ticket bookParking(Vehicle vehicle, int entryGateNumber) {
        if(tickets.containsKey(vehicle.getVehicleID())) {
            System.out.println("Vehicle #" + vehicle.getVehicleID() + " has already a booked parking spot. Free that spot first and then try again!");
            return null;
        }
        spotBookingStrategy.bookParkingSpot(vehicle, entryGateNumber);
        // if we use above strategy then don't need to implement below code
        EntryGate entryGate = parkingLot.getEntryGates().get(entryGateNumber);
        Map<Integer, ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for(Integer floorNumber : parkingFloors.keySet()) {
            Map<Integer, ParkingSpot> parkingSpots = parkingFloors.get(floorNumber).getParkingSpots();
            for(Integer spotID : parkingSpots.keySet()) {
                ParkingSpot parkingSpot = parkingSpots.get(spotID);
                if(parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicle.getVehicleType()) {
                    parkingSpot.setAvailable(false);
                    parkingSpot.setVehicle(vehicle);
                    Ticket ticket = generateTicket(vehicle, entryGateNumber, floorNumber, parkingSpot);
                    System.out.println("Parking Spot #" + spotID + " on floor #" + floorNumber + " booked successfully for Vehicle #" + vehicle.getVehicleID());
                    tickets.put(vehicle.getVehicleID(), ticket);
                    return ticket;
                }
            }
        }
        return null;
    }

    public boolean freeParking(Ticket ticket) {
        Vehicle vehicle = ticket.getVehicle();
        if(!tickets.containsKey(vehicle.getVehicleID())) {
            System.out.println("Vehicle #" + vehicle.getVehicleID() + " doesn't have any booked parking spot");
            return false;
        } else {
            // Process Payment
            double amount = calculateCost(ticket);

            tickets.remove(vehicle.getVehicleID());
            ParkingSpot parkingSpot = ticket.getParkingSpot();
            parkingSpot.setAvailable(true);
            System.out.println("Parking Spot #" + parkingSpot.getSpotID() + " freed successfully");
            return true;
        }
    }

    public double calculateCost(Ticket ticket) {
        long exitTime = new Date().getTime();
        long entryTime = ticket.getEntryTime();
        int spotPrice = ticket.getParkingSpot().getVehicleType().getPrice();
        return (exitTime - entryTime) * spotPrice;
    }

    private Ticket generateTicket(Vehicle vehicle, int entryGateNumber, int floorNumber, ParkingSpot parkingSpot) {
        Ticket ticket = new Ticket(random.nextInt(), vehicle, new Date().getTime(), entryGateNumber, floorNumber, parkingSpot);
        return ticket;
    }
}
