package matchercor;

import models.User;

public interface Matcher {

    public double calculateMatchScore(User user1, User user2);
}
