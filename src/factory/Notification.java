package factory;

import adapter.NotificationAdapter;
import adapter.ExternalNotificationService;
import observer.Observer;

public class Notification implements Observer {
    private final NotificationAdapter notificationClient;

    public Notification() {
        this.notificationClient = new NotificationAdapter(new ExternalNotificationService());
    }

    @Override
    public void update(String message) {
        notificationClient.notifyUser("[NOTIFICATION] " + message);
    }
}
