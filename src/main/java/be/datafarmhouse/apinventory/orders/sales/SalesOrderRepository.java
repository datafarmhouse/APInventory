package be.datafarmhouse.apinventory.orders.sales;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends JpaRepository<SalesOrderData, String> {
}
