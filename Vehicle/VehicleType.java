package Vehicle;

public enum VehicleType {
    TWOWHEELER(20),
    FOURWHEELER(40);

    private int price;

    VehicleType(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}
