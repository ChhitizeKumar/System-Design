package strategies;

public class SMSStrategy implements NotificationStrategy{

    private String mobileNumber;

    public SMSStrategy(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("Sending sms notification to: " + mobileNumber + "\n" + content);
    }
}
