package jhooks.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity(name = "jhooks_events")
public class WebhookEventData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private WebhookData webhook;
    @Lob
    private String payload;
    private boolean success;
    private Date trigger;
}
