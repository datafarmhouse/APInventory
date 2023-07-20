package jhooks.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebhookRepository extends JpaRepository<WebhookData, Long> {

}
