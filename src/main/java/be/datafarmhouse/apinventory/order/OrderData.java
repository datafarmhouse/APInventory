package be.datafarmhouse.apinventory.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "orders")
public class OrderData {

    @Id
    private String code;
}
