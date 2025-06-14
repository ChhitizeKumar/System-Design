package observableobserver;

import strategies.NotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class NotificationEngineObserver implements Observer{

    private NotificationObservable notificationObservable;
    private List<NotificationStrategy> notificationStrategies;

    public NotificationEngineObserver(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
        notificationStrategies = new ArrayList<>();
    }

    @Override
    public void update() {

        String content = notificationObservable.getNotificationContent();

        for (NotificationStrategy strategy:notificationStrategies)
        {
            strategy.sendNotification(content);
        }

    }

    public void addStrategy(NotificationStrategy strategy)
    {
        notificationStrategies.add(strategy);
    }
}
