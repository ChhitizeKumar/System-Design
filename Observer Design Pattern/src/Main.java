public class Main {
    public static void main(String[] args) {

        Channel channel = new Channel("Get placed with Chhitize");

        ISubscriber subscriber1 = new Subscriber("Rohit Singh", channel);
        ISubscriber subscriber2 = new Subscriber("Devank Dalal", channel);

        channel.addSubscriber(subscriber1);
        channel.addSubscriber(subscriber2);
        channel.uploadVideo("DSA guide in C++");

        channel.removeSubscriber(subscriber1);
        channel.uploadVideo("Ultimate Java Guide");
    }
}