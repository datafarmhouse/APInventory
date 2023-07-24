package be.datafarmhouse.apinventory.orders.purchase;

import be.datafarmhouse.apinventory.contacts.ContactData;
import be.datafarmhouse.apinventory.util.AddressData;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity(name = "vendors")
public class VendorData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;
    private String name;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private AddressData address = new AddressData();
    @Email
    private String email;
    private String phone;
    private String vatNumber;
    private String bankAccount;
    @ManyToOne
    private ContactData contact;

}
