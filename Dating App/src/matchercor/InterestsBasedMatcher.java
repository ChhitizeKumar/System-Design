package matchercor;

import models.Interest;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class InterestsBasedMatcher implements Matcher{
    @Override
    public double calculateMatchScore(User user1, User user2) {

        BasicMatcher basicMatcher = new BasicMatcher();

        double basicMatcherScore = basicMatcher.calculateMatchScore(user1, user2);

        if(basicMatcherScore == 0.0)
            return 0.0;

        List<String> user1InterestNames = new ArrayList<>();
        for (Interest interest : user1.getProfile().getInterests()) {
            user1InterestNames.add(interest.getName());
        }

        int sharedInterests = 0;
        for (Interest interest : user2.getProfile().getInterests()) {
            if (user1InterestNames.contains(interest.getName())) {
                sharedInterests++;
            }
        }

        // Bonus score based on shared interests (up to 0.5 additional points)
        double maxInterests = Math.max(user1.getProfile().getInterests().size(), user2.getProfile().getInterests().size());
        double interestScore = maxInterests > 0 ? 0.5 * ((double) sharedInterests / maxInterests) : 0.0;

        return basicMatcherScore + interestScore;

    }
}
