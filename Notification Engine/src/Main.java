import notification.Notification;
import notification.SignatureDecorator;
import notification.SimpleNotification;
import notification.TimeStampDecorator;
import observableobserver.LoggerObserver;
import observableobserver.NotificationEngineObserver;
import observableobserver.NotificationObservable;
import observableobserver.Observer;
import service.NotificationService;
import strategies.EmailStrategy;
import strategies.PopUpStrategy;
import strategies.SMSStrategy;

public class Main {
    public static void main(String[] args) {

        Notification notification = new SimpleNotification("New post posted by your friend!");

        notification = new SignatureDecorator(notification);
        notification = new TimeStampDecorator(notification);


        NotificationService notificationService = NotificationService.getInstance();
        NotificationObservable observable = notificationService.getObservable();

        // Observer/Subscriber 1
        LoggerObserver loggerObserver = new LoggerObserver(observable);

        // Observer/Subscriber 2
        NotificationEngineObserver notificationEngineObserver = new NotificationEngineObserver(observable);
        notificationEngineObserver.addStrategy(new EmailStrategy("chhitizekumar@gmail.com"));
        notificationEngineObserver.addStrategy(new SMSStrategy("+91 7891653872"));
        notificationEngineObserver.addStrategy(new PopUpStrategy());

        observable.addObserver(loggerObserver);
        observable.addObserver(notificationEngineObserver);

        notificationService.sendNotification(notification);

    }
}