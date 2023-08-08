package be.datafarmhouse.apinventory.contacts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "contacts")
public class ContactData {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phone;
}
