package co.develhope.librarymanagement.repository.inventory;

import co.develhope.librarymanagement.entities.inventory.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
