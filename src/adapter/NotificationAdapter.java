package adapter;

public class NotificationAdapter implements NotificationClient {
    private final ExternalNotificationService externalService;

    public NotificationAdapter(ExternalNotificationService externalService) {
        this.externalService = externalService;
    }

    @Override
    public void notifyUser(String message) {
        // Adapting method call
        externalService.sendAlert(message);
    }
}
