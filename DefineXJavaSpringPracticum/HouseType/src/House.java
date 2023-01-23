public class House {
    private double price;
    private double squareMeters;
    private int rooms;
    private int salons;

    public House(double price, double squareMeters, int rooms, int salons) {
        this.price = price;
        this.squareMeters = squareMeters;
        this.rooms = rooms;
        this.salons = salons;
    }

    public double getPrice() {
        return price;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public int getRooms() {
        return rooms;
    }

    public int getSalons() {
        return salons;
    }
}
