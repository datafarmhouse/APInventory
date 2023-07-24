package be.datafarmhouse.apinventory.util;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "addresses")
public class AddressData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;
    private String line1;
    private String line2;
    private String postalCode;
    private String city;
    private String country;
}
