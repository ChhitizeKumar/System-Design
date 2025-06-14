package service;

import notification.Notification;
import observableobserver.NotificationObservable;
import observableobserver.Observable;

import java.util.ArrayList;
import java.util.List;

//Singleton Class
public class NotificationService {

    //to store all notification
    private List<Notification> notifications = new ArrayList<>();
    private static NotificationService instance = null;
    private NotificationObservable observable;

    private NotificationService() {
        this.observable = new NotificationObservable();
    }

    public static NotificationService getInstance()
    {
        if(instance == null)
            instance = new NotificationService();
        return instance;
    }

    public NotificationObservable getObservable()
    {
        return  observable;
    }

    public void sendNotification(Notification notification)
    {
        notifications.add(notification);
        observable.setNotification(notification);
    }


}
