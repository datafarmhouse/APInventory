package be.datafarmhouse.apinventory.returns;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository extends JpaRepository<ReturnData, String> {
}
