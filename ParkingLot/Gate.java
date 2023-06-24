package ParkingLot;

public class Gate {
    private int gateID;
    public boolean isOpen;

    public Gate(int gateID, boolean isOpen) {
        this.gateID = gateID;
        this.isOpen = isOpen;
    }
    public void closeGate() {
        isOpen = false;
    }

    public void openGate() {
        isOpen = true;
    }

    public int getGateID() {
        return gateID;
    }
}
