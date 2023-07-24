package be.datafarmhouse.apinventory.orders.sales;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "orders_sales")
public class SalesOrderData {

    @Id
    private String code;
}
