package notification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStampDecorator extends NotificationDecorator{
    public TimeStampDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String time = now.format(formatter);

        return time + " -- " + notification.getContent();
    }
}
