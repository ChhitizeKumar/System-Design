package notification;

import java.util.HashMap;
import java.util.Map;

//Observable
//Singleton
public class NotificationService {

    public static final NotificationService instance = new NotificationService();

    public static NotificationService getInstance(){
        return instance;
    }

    private Map<String, NotificationObserver> observers;

    private NotificationService(){
        observers = new HashMap<>();
    }

    public void registerObserver(String userId, NotificationObserver observer){

        observers.putIfAbsent(userId, observer);
    }

    public void removeObserver(String userid){
        observers.remove(userid);
    }

    public void notifyObserver(String userId, String msg){
        observers.get(userId).update(msg);
    }

    public void notifyAll(String msg){

        for(Map.Entry<String, NotificationObserver> it: observers.entrySet()){
            it.getValue().update(msg);
        }
    }
}
