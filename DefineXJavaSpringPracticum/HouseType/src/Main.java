import java.util.List;

public class Main {

    public static void main(String[] args) {

        PropertyService propertyService = new PropertyService();
        System.out.println("Total price of houses: " + propertyService.getTotalPriceOfHouses());
        System.out.println("Total price of villas: " + propertyService.getTotalPriceOfVillas());
        System.out.println("Total price of summeries: " + propertyService.getTotalPriceOfSummeries());
        System.out.println("Total price of all properties: " + propertyService.getTotalPriceOfAllProperties());
        System.out.println("Average square meters of houses: " + propertyService.getAverageSquareMetersOfHouses());
        System.out.println("Average square meters of villas: " + propertyService.getAverageSquareMetersOfVillas());
        System.out.println("Average square meters of summeries: " + propertyService.getAverageSquareMetersOfSummeries());
        System.out.println("Average square meters of all properties: " + propertyService.getAverageSquareMetersOfAllProperties());
        List<House> filteredProperties = propertyService.filterPropertiesByRoomsAndSalons(3, 2);
        System.out.println("Properties with at least 3 rooms and 2 salons:");

        for (House property : filteredProperties) {
            System.out.println(" - Price: " + property.getPrice() + " Square meters: " + property.getSquareMeters() + " Rooms: " + property.getRooms() + " Salons: " + property.getSalons());
        }
    }
}