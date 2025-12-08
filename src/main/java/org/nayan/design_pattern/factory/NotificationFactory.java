package org.nayan.design_pattern.factory;

public class NotificationFactory {

    public static Notification getNotification(String type) {
        if (type == null) {
            return null;
        }
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}
