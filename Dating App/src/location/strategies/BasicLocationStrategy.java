package location.strategies;

import models.Location;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class BasicLocationStrategy implements LocationStrategy{
    @Override
    public List<User> findNearbyUsers(Location location, double maxDistance, List<User> allUsers) {

        List<User> filteredUsers = new ArrayList<>();

        for(User user:allUsers){

            if(location.distanceInKm(user.getProfile().getLocation()) <= maxDistance)
                filteredUsers.add(user);
        }

        return filteredUsers;
    }

}
