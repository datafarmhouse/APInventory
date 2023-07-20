package jhooks.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "jhooks_webhooks")
public class WebhookData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String externalUserID;
    private String eventType;


    private String method;
    private String url;
    private String headers;

}
