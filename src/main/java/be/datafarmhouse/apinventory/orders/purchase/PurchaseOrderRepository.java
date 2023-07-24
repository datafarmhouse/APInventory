package be.datafarmhouse.apinventory.orders.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrderData, String> {
}
