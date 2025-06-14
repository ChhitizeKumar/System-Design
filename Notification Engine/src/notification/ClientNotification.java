package notification;

public class ClientNotification {
    public static void main(String[] args) {
        Notification notification = new SimpleNotification("New message received!");

        notification = new SignatureDecorator(notification);
        notification = new TimeStampDecorator(notification);

        System.out.println(notification.getContent());
    }
}
