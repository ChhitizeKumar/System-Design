package notification;

public class SignatureDecorator extends NotificationDecorator{

    public SignatureDecorator(Notification notification){
        super(notification);
    }

    @Override
    public String getContent() {
        return notification.getContent() + "\n ---signed by Chhitize Kumar";
    }
}
