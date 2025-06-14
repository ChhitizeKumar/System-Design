package strategies;

public class PopUpStrategy implements NotificationStrategy{
    @Override
    public void sendNotification(String content) {
        System.out.println("Sending Pop Up notification...." + "\n" + content);
    }
}
