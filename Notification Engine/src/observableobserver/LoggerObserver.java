package observableobserver;

public class LoggerObserver implements Observer{

    private NotificationObservable observable;

    public LoggerObserver(NotificationObservable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Logging the Notification received....\n"
                + observable.getNotificationContent());
    }
}
