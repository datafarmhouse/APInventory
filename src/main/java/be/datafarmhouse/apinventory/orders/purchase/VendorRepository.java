package be.datafarmhouse.apinventory.orders.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<VendorData, String> {
}
