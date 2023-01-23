import java.util.ArrayList;
import java.util.List;

public class PropertyService {
    private List<House> houses = new ArrayList<>();
    private List<Villa> villas = new ArrayList<>();
    private List<Summery> summeries = new ArrayList<>();

    public PropertyService(){
        houses.add(new House(100000, 50, 2, 1));
        houses.add(new House(200000, 70, 3, 2));
        houses.add(new House(150000, 60, 2, 1));

        villas.add(new Villa(300000, 120, 4, 3, true));
        villas.add(new Villa(400000, 150, 5, 4, true));
        villas.add(new Villa(350000, 130, 4, 3, false));

        summeries.add(new Summery(200000, 100, 3, 2, true));
        summeries.add(new Summery(250000, 110, 3, 2, false));
        summeries.add(new Summery(220000, 105, 3, 2, true));
    }

    public List<House> getHouses() {
        return houses;
    }

    public List<Villa> getVillas() {
        return villas;
    }

    public List<Summery> getSummeries() {
        return summeries;
    }

    public double getTotalPriceOfHouses(){
        double totalPrice = 0;
        for (House house: houses) {
            totalPrice += house.getPrice();
        }
        return totalPrice;
    }

    public double getTotalPriceOfVillas(){
        double totalPrice = 0;
        for (Villa villa: villas) {
            totalPrice += villa.getPrice();
        }
        return totalPrice;
    }
    public double getTotalPriceOfSummeries(){
        double totalPrice = 0;
        for (Summery summery: summeries) {
            totalPrice += summery.getPrice();
        }
        return totalPrice;
    }

    public double getTotalPriceOfAllProperties(){
        return getTotalPriceOfHouses() + getTotalPriceOfSummeries() + getTotalPriceOfVillas();
    }

    public double getAverageSquareMetersOfHouses(){
        double totalSquareMeters = 0;
        for (House house: houses) {
            totalSquareMeters += house.getSquareMeters();
        }
        return totalSquareMeters / houses.size();
    }

    public double getAverageSquareMetersOfVillas(){
        double totalSquareMeters = 0;
        for (Villa villa: villas) {
            totalSquareMeters += villa.getSquareMeters();
        }
        return totalSquareMeters / villas.size();
    }

    public double getAverageSquareMetersOfSummeries(){
        double totalSquareMeters = 0;
        for (Summery summery: summeries) {
            totalSquareMeters += summery.getSquareMeters();
        }
        return totalSquareMeters / summeries.size();
    }

    public double getAverageSquareMetersOfAllProperties(){
        int totalProperties = houses.size() + villas.size() + summeries.size();
        return (getAverageSquareMetersOfSummeries() + getAverageSquareMetersOfHouses() + getAverageSquareMetersOfVillas()) / totalProperties;
    }

    public List<House> filterPropertiesByRoomsAndSalons(int minRooms, int minSalons) {
        List<House> filteredProperties = new ArrayList<>();
        for (House house : houses) {
            if (house.getRooms() >= minRooms && house.getSalons() >= minSalons) {
                filteredProperties.add(house);
            }
        }
        for (Villa villa : villas) {
            if (villa.getRooms() >= minRooms && villa.getSalons() >= minSalons) {
                filteredProperties.add(villa);
            }
        }
        for (Summery summery : summeries) {
            if (summery.getRooms() >= minRooms && summery.getSalons() >= minSalons) {
                filteredProperties.add(summery);
            }
        }
        return filteredProperties;
    }




}
