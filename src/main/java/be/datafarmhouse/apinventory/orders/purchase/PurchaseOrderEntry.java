package be.datafarmhouse.apinventory.orders.purchase;

import be.datafarmhouse.apinventory.util.AbstractOrderEntry;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class PurchaseOrderEntry extends AbstractOrderEntry {

    @ManyToOne
    private PurchaseOrderData order;
}
