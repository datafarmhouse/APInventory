package be.datafarmhouse.apinventory.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockEventRepository extends JpaRepository<StockEventData, String> {
}
