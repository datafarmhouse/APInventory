package jhooks;

import jhooks.data.WebhookCallRepository;
import jhooks.data.WebhookData;
import jhooks.data.WebhookEventRepository;
import jhooks.data.WebhookRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JHookService {

    private final WebhookRepository webhookRepository;
    private final WebhookEventRepository webhookEventRepository;
    private final WebhookCallRepository webhookCallRepository;

    public void publish(final Event event) {
        publish(event, null);
    }

    public void publish(final Event event, final String externalUserID) {
        final List<WebhookData> registrations = checkRegistrations(event.getType(), externalUserID);
        if (registrations.isEmpty()) {
            return;
        }
        scheduleExecution(registrations, event);
    }

    public List<WebhookData> checkRegistrations(final String type, final String externalUserID) {
        return null;
    }

    public void scheduleExecution(final List<WebhookData> registrations, final Event event) {

    }

    @Data
    @Builder
    public static class Event {

        private String type;
        private Object data;
    }
}
