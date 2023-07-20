package be.datafarmhouse.apinventory.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductData, String> {

}
