package jhooks.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebhookCallRepository extends JpaRepository<WebhookCallData, Long> {

}
