package notification;

public class UserNotificationObserver implements NotificationObserver{

    private String userId;

    public UserNotificationObserver(String userId) {
        this.userId = userId;
    }

    @Override
    public void update(String msg) {
        System.out.println("Notification for user " + userId + ": " + msg);
    }
}
