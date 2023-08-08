package be.datafarmhouse.apinventory.orders.purchase;

import be.datafarmhouse.apinventory.util.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity(name = "orders_purchase")
public class PurchaseOrderData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private VendorData vendor;
    private OrderStatus status;
    @ToString.Exclude
    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL})
    private List<PurchaseOrderEntry> entries;

}
