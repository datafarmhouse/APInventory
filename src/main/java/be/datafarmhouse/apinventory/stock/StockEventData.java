package be.datafarmhouse.apinventory.stock;

import be.datafarmhouse.apinventory.products.ProductData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "stock_events")
@Table(indexes = {
        @Index(name = "stock_events_product", columnList = "product_code")
})
public class StockEventData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne
    private ProductData product;
    private Long quantity;
    @Column(nullable = false)
    private String event;
}
