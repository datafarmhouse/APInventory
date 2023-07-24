package be.datafarmhouse.apinventory.api;

import be.datafarmhouse.apinventory.products.ProductData;
import be.datafarmhouse.apinventory.products.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductAPI {

    private final ProductService productService;

    @PostMapping("/api/products")
    public void createProduct(@RequestBody final ProductData product) {
        productService.create(product);
    }
}
