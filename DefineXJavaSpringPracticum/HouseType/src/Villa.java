public class Villa extends House{
    private boolean hasPool;

    public Villa(double price, double squareMeters, int rooms, int salons, boolean hasPool) {
        super(price, squareMeters, rooms, salons);
        this.hasPool = hasPool;
    }

    public boolean isHasPool() {
        return hasPool;
    }
}
