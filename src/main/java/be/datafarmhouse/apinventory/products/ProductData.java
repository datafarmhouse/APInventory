package be.datafarmhouse.apinventory.products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "products")
public class ProductData {

    @Id
    private String code;
    private String ean;
    private String name;

    private Double weightInKg;
    private Double widthInCm, heightInCm, lengthInCm;
}
