import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Object findRestaurantByName(String restaurantName) throws restaurantNotFoundException {

        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        ListIterator itr = getRestaurants().listIterator();

        while (itr.hasNext()) {
            Restaurant restaurant = (Restaurant) itr.next();
            if (restaurant.getName().equals(restaurantName)) {
                return restaurant;

            }
        }
        throw new restaurantNotFoundException("The restaurant named "+restaurantName+" is not found");

    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = (Restaurant) findRestaurantByName(restaurantName);
        if(restaurantToBeRemoved != null) {
            restaurants.remove(restaurantToBeRemoved);
            return restaurantToBeRemoved;
        }
        else  throw new restaurantNotFoundException("The restaurant named "+restaurantName+" is not found");

    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
