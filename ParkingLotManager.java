import ParkingLot.ParkingLot;
import ParkingLot.ParkingFloor;
import ParkingLot.ParkingSpot;
import ParkingLot.EntryGate;
import ParkingLot.ExitGate;

public class ParkingLotManager {
    private ParkingLot parkingLot;

    public ParkingLotManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void addEntryGate(EntryGate entryGate) {
        if(parkingLot.getEntryGates().containsKey(entryGate.getGateID())) {
            System.out.println("Entry Gate #" + entryGate.getGateID() + " is already present in Parking Lot #" + parkingLot.getParkingLotID());
        } else {
            parkingLot.getEntryGates().put(entryGate.getGateID(), entryGate);
            System.out.println("Entry Gate #" + entryGate.getGateID() + " added to Parking Lot #" + parkingLot.getParkingLotID());
        }
    }

    public void removeEntryGate(int gateID) {
        if(!parkingLot.getEntryGates().containsKey(gateID)) {
            System.out.println("Entry Gate #" + gateID + " is not present in Parking Lot #" + parkingLot.getParkingLotID());
        } else {
            parkingLot.getEntryGates().remove(gateID);
            System.out.println("Entry Gate #" + gateID + " removed from Parking Lot #" + parkingLot.getParkingLotID());
        }
    }

    public void addExitGate(ExitGate exitGate) {
        if(parkingLot.getExitGates().containsKey(exitGate.getGateID())) {
            System.out.println("Exit Gate #" + exitGate.getGateID() + " is already present in Parking Lot #" + parkingLot.getParkingLotID());
        } else {
            parkingLot.getExitGates().put(exitGate.getGateID(), exitGate);
            System.out.println("Exit Gate #" + exitGate.getGateID() + " added to Parking Lot #" + parkingLot.getParkingLotID());
        }
    }

    public void removeExitGate(int gateID) {
        if(!parkingLot.getExitGates().containsKey(gateID)) {
            System.out.println("Exit Gate #" + gateID + " is not present in Parking Lot #" + parkingLot.getParkingLotID());
        } else {
            parkingLot.getExitGates().remove(gateID);
            System.out.println("Exit Gate #" + gateID + " removed Parking Lot #" + parkingLot.getParkingLotID());
        }
    }

    public void addFloor(ParkingFloor parkingFloor) {
        if(parkingLot.getParkingFloors().containsKey(parkingFloor.getFloorNumber())) {
            System.out.println("Floor #" + parkingFloor.getFloorNumber() + " is already present in Parking Lot #" + parkingLot.getParkingLotID());
        } else {
            System.out.println("Floor Number #" + parkingFloor.getFloorNumber() + " added to Parking Lot #" + parkingLot.getParkingLotID());
            parkingLot.getParkingFloors().put(parkingFloor.getFloorNumber(), parkingFloor);
        }
    }

    public void removeFloor(int floorNumber) {
        if(!parkingLot.getParkingFloors().containsKey(floorNumber)) {
            System.out.println("Floor Number #" + floorNumber + " is not present in Parking Lot #" + parkingLot.getParkingLotID());
        } else {
            parkingLot.getParkingFloors().remove(floorNumber);
            System.out.println("Floor Number #" + floorNumber + " removed from Parking Lot #" + parkingLot.getParkingLotID());
        }
    }

    public void addParkingSpot(ParkingSpot parkingSpot, int floorNumber) {
        ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(floorNumber);
        if(parkingFloor == null) {
            System.out.println("Floor Number #" + floorNumber + " is not present in Parking Lot #" + parkingLot.getParkingLotID());
        } else {
            if(parkingFloor.getParkingSpots().containsKey(parkingSpot.getSpotID())) {
                System.out.println("Parking Spot #" + parkingSpot.getSpotID() + " is already present on floor #" + floorNumber);
            } else {
                System.out.println("Parking Spot #" + parkingSpot.getSpotID() + " added to floor #" + floorNumber);
                parkingFloor.getParkingSpots().put(parkingSpot.getSpotID(), parkingSpot);
            }
        }
    }

    public void removeParkingSpot(int parkingSpotID, int floorNumber) {
        ParkingFloor parkingFloor = parkingLot.getParkingFloors().get(floorNumber);
        if(parkingFloor == null) {
            System.out.println("Floor Number #" + floorNumber + " is not present in Parking Lot #" + parkingLot.getParkingLotID());
        } else {
            if(!parkingFloor.getParkingSpots().containsKey(parkingSpotID)) {
                System.out.println("Parking Spot #" + parkingSpotID + " is not present on floor #" + floorNumber);
            } else {
                parkingFloor.getParkingSpots().remove(parkingSpotID);
                System.out.println("Parking Spot #" + parkingSpotID + " removed from floor #" + floorNumber);
            }
        }
    }
}
