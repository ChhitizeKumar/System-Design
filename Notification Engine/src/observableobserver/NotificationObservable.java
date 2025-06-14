package observableobserver;

import notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationObservable implements Observable{

    private List<Observer> observers = new ArrayList<>();
    //subject
    private Notification notification;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {

        for(Observer observer:observers)
        {
            observer.update();
        }
    }

    public void setNotification(Notification notfi)
    {
        notification = notfi;
        notifyAllObserver();
    }

    public Notification getNotification()
    {
        return notification;
    }

    public String getNotificationContent()
    {
        return notification.getContent();
    }
}
