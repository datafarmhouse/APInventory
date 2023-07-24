package be.datafarmhouse.apinventory.contacts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactData, String> {
}
