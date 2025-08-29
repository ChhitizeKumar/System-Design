package location.strategies;

import models.Location;
import models.User;

import java.util.List;

public interface LocationStrategy {

    public List<User> findNearbyUsers(Location location,
                               double maxDistance,
                               List<User> allUsers);
}
