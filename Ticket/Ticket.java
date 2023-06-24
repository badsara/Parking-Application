package Ticket;

import ParkingLot.ParkingSpot;
import Vehicle.Vehicle;

public class Ticket {
    private int ticketNumber;
    private Vehicle vehicle;
    private long entryTime;
    private int entryGateNumber;
    private int floorNumber;
    private ParkingSpot parkingSpot;

    public Ticket(int ticketNumber, Vehicle vehicle, long entryTime, int entryGateNumber, int floorNumber, ParkingSpot parkingSpot) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.entryGateNumber = entryGateNumber;
        this.floorNumber = floorNumber;
        this.parkingSpot = parkingSpot;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public int getEntryGateNumber() {
        return entryGateNumber;
    }

    public void setEntryGateNumber(int entryGateNumber) {
        this.entryGateNumber = entryGateNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
