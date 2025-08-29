package location;

import location.strategies.BasicLocationStrategy;
import location.strategies.LocationStrategy;
import models.Location;
import models.User;

import java.util.List;

//Singleton
public class LocationService {

    private static final LocationService instance = new LocationService();

    public static LocationService getInstance(){
        return instance;
    }

    private LocationStrategy locationStrategy;

    private LocationService(){
        locationStrategy = new BasicLocationStrategy();
    }


    public void setLocationStrategy(LocationStrategy locationStrategy) {
        this.locationStrategy = locationStrategy;
    }

    public List<User> findNearbyUsers(Location location, double maxDistance, List<User> allUsers)
    {
        return locationStrategy.findNearbyUsers(location, maxDistance, allUsers);
    }
}
