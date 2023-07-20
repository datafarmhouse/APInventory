package be.datafarmhouse.apinventory.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderData, String> {
}
