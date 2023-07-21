package be.datafarmhouse.apinventory.product;

import be.datafarmhouse.apinventory.ui.components.CRUDEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "products")
public class ProductData implements CRUDEntity {

    @Id
    private String code;
    private String ean;
    private String name;

    private Double weightInKg;
    private Double widthInCm, heightInCm, lengthInCm;
}
