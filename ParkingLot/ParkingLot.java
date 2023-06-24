package ParkingLot;

import java.util.*;

public class ParkingLot {
    private int parkingLotID;
    private Map<Integer, EntryGate> entryGates;
    private Map<Integer, ExitGate> exitGates;
    private Map<Integer, ParkingFloor> parkingFloors;

    public ParkingLot(int parkingLotID) {
        this.parkingLotID = parkingLotID;
        this.entryGates = new HashMap<>();
        this.exitGates = new HashMap<>();
        this.parkingFloors = new HashMap<>();
    }

    public int getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(int parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public Map<Integer, EntryGate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(Map<Integer, EntryGate> entryGates) {
        this.entryGates = entryGates;
    }

    public Map<Integer, ExitGate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(Map<Integer, ExitGate> exitGates) {
        this.exitGates = exitGates;
    }

    public Map<Integer,ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(Map<Integer, ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
