package strategies;

public class EmailStrategy implements NotificationStrategy{
    private String emailId;

    public EmailStrategy(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void sendNotification(String content) {
        System.out.println("Sending email notification to emailId: "+emailId + "\n" + content);
    }
}
