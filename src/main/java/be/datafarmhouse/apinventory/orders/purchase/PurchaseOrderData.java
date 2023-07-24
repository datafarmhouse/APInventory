package be.datafarmhouse.apinventory.orders.purchase;

import be.datafarmhouse.apinventory.util.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "orders_purchase")
public class PurchaseOrderData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private VendorData vendor;
    private OrderStatus status;
    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL})
    private List<PurchaseOrderEntry> entries;

}
