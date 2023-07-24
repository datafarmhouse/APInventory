package be.datafarmhouse.apinventory.util;

import be.datafarmhouse.apinventory.products.ProductData;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "orders_entries")
public abstract class AbstractOrderEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;
    @ManyToOne
    private ProductData product;
    private Long quantity;
    private Double price;
    private Double discount;
    private Double vat;
    private Double total;
}
