package co.develhope.librarymanagement.repository.inventory;

import co.develhope.librarymanagement.entities.inventory.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Long> {
}
