import ParkingLot.*;
import Payment.PayByCard;
import Payment.Payment;
import SpotBookingStrategy.FarFromEntryGateStrategy;
import SpotBookingStrategy.NearToEntryGateStrategy;
import Vehicle.Vehicle;
import Vehicle.VehicleType;
import Ticket.Ticket;

public class MainApplication {
    public static void main(String[] args) {
        // Parking Lot and its Manager
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLotManager parkingLotManager1 = new ParkingLotManager(parkingLot1);

        // Initialize Parking Lot with some spots and floors
        initParkingLot(parkingLotManager1);

        // Creating Vehicle #1 and #2
        Vehicle vehicle1 = new Vehicle(1, VehicleType.TWOWHEELER);
        Vehicle vehicle2 = new Vehicle(2, VehicleType.FOURWHEELER);

        // Parking Service initialization
        ParkingService parkingService = new ParkingService(parkingLot1, new FarFromEntryGateStrategy());

        // Booking Parking Spot
        Ticket ticket1 = parkingService.bookParking(vehicle1, 1);
        Ticket ticket2 = parkingService.bookParking(vehicle2, 1);
        Ticket ticket3 = parkingService.bookParking(vehicle1, 1);

        // Take Payment and Free Parking Spot
        Payment payment1 = new PayByCard();
        double amount1 = parkingService.calculateCost(ticket1);
        boolean paymentStatus = payment1.processPayment(amount1);
        if(paymentStatus == true) parkingService.freeParking(ticket1);
        parkingService.freeParking(ticket2);
    }

    private static void initParkingLot(ParkingLotManager parkingLotManager) {
        // Creating some floors
        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingFloor floor2 = new ParkingFloor(2);
        ParkingFloor floor3 = new ParkingFloor(3);

        // Adding floors to Parking Lot #1
        parkingLotManager.addFloor(floor1);
        parkingLotManager.addFloor(floor2);
        parkingLotManager.addFloor(floor3);

        // Removing floors from Parking Lot #2
        parkingLotManager.removeFloor(2);
        parkingLotManager.removeFloor(4);

        // Creating some parking Spots
        ParkingSpot parkingSpot1 = new ParkingSpot(1, VehicleType.TWOWHEELER, true);
        ParkingSpot parkingSpot2 = new ParkingSpot(2, VehicleType.TWOWHEELER, true);
        ParkingSpot parkingSpot3 = new ParkingSpot(3, VehicleType.FOURWHEELER, true);
        ParkingSpot parkingSpot4 = new ParkingSpot(4, VehicleType.FOURWHEELER, true);

        // Adding parking spots to Parking Lot #1
        parkingLotManager.addParkingSpot(parkingSpot1, 1);
        parkingLotManager.addParkingSpot(parkingSpot2, 2);
        parkingLotManager.addParkingSpot(parkingSpot3, 3);
        parkingLotManager.addParkingSpot(parkingSpot4, 1);
        parkingLotManager.addParkingSpot(parkingSpot2, 1);

        // Removing parking spots from Parking Lot #1
        parkingLotManager.removeParkingSpot(1, 1);
        parkingLotManager.removeParkingSpot(3, 1);

        // Creating entry and exit gates for Parking Lot #1
        EntryGate entryGate = new EntryGate(1, true);
        ExitGate exitGate = new ExitGate(2, true);

        // Adding gates to parking Lot #1
        parkingLotManager.addEntryGate(entryGate);
        parkingLotManager.addExitGate(exitGate);
    }
}
