package be.datafarmhouse.apinventory.returns;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ReturnData {

    @Id
    private String code;
}
