package jhooks.scheduling;

import jhooks.data.WebhookEventData;
import org.quartz.Job;
import org.quartz.JobExecutionContext;


public class WebhookCaller implements Job {

    @Override
    public void execute(final JobExecutionContext context) {
        final WebhookEventData event = (WebhookEventData) context.get("event");
    }
}
