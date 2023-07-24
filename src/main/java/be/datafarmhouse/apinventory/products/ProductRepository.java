package be.datafarmhouse.apinventory.products;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductData, String> {

}
