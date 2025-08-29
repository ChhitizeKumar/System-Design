package models;

import notification.NotificationObserver;
import notification.NotificationService;
import notification.UserNotificationObserver;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String userId;
    private UserProfile userProfile;
    private Preference preference;
    private Map<String, SwipeAction> swipeHistory;
    private NotificationObserver notificationObserver;

    public User(String userId) {
        this.userId = userId;
        userProfile = new UserProfile();
        preference = new Preference();
        swipeHistory = new HashMap<>();
        notificationObserver = new UserNotificationObserver(userId);

        NotificationService.getInstance().registerObserver(userId, notificationObserver);
    }

    public String getId() {
        return userId;
    }

    public UserProfile getProfile() {
        return userProfile;
    }

    public Preference getPreference() {
        return preference;
    }

    public void swipe(String userId, SwipeAction action){
        swipeHistory.put(userId, action);
    }

    public boolean hasLiked(String userId){
        return swipeHistory.containsKey(userId) && swipeHistory.get(userId) == SwipeAction.RIGHT;
    }

    public boolean hasDisliked(String userId){
        return swipeHistory.containsKey(userId) && swipeHistory.get(userId) == SwipeAction.LEFT;
    }

    public boolean hasInteractedWith(String otherUserId) {
        return swipeHistory.containsKey(otherUserId);
    }

    public void displayProfile() {  // Principle of least knowledge
        userProfile.display();
    }
}
