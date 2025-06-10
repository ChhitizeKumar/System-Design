import java.util.ArrayList;
import java.util.List;

public class Channel implements IChannel{

    private List<ISubscriber> subscribers;
    private String name;
    private String latestVideo;

    public Channel(String name)
    {
        this.subscribers = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {
        if(!subscribers.contains(subscriber))
            subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {

        for(ISubscriber subscriber:subscribers)
        {
            subscriber.update();
        }
    }

    //Set Subject
    public void uploadVideo(String video)
    {
        this.latestVideo = video;
        System.out.println("Channel: " + name + " has uploaded " + video);
        notifySubscribers();
    }

    //Get subject
    public String getVideo()
    {
        return "\nCheckout our new Video : " + latestVideo + "\n";
    }
}
