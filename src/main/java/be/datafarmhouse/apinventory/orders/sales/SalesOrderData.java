package be.datafarmhouse.apinventory.orders.sales;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "orders_sales")
public class SalesOrderData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
}
