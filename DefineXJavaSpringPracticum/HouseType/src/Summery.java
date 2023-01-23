public class Summery extends House{
    private boolean hasGarden;

    public Summery(double price, double squareMeters, int rooms, int salons, boolean hasGarden) {
        super(price, squareMeters, rooms, salons);
        this.hasGarden = hasGarden;
    }
}
