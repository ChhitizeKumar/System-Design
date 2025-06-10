package managers;

import models.Restaurant;

import java.util.ArrayList;
import java.util.List;

//Singleton Class
//Service -> Bean
public class RestaurantManager {

    private List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager restaurantManagerInstance = null;

    private RestaurantManager()
    {

    }

    public static RestaurantManager getRestaurantManagerInstance()
    {
        if(restaurantManagerInstance == null)
            restaurantManagerInstance = new RestaurantManager();

        return restaurantManagerInstance;
    }

    public void addRestaurant(Restaurant restaurant)
    {
        restaurants.add(restaurant);
    }

    public List<Restaurant> searchByLocation(String loc)
    {
        List<Restaurant> result = new ArrayList<>();
        loc = loc.toLowerCase();
        for (Restaurant r : restaurants) {
            String rl = r.getLocation().toLowerCase();
            if (rl.equals(loc)) {
                result.add(r);
            }
        }
        return result;
    }
}
