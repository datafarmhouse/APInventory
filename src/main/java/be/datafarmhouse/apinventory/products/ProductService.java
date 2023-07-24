package be.datafarmhouse.apinventory.products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductData create(final ProductData product) {
        return productRepository.save(product);
    }
}
