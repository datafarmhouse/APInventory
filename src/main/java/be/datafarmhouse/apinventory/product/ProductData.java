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
    private String name;
    private String description;
}
