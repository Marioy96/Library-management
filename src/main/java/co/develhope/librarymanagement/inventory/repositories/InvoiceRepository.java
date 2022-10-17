package co.develhope.librarymanagement.inventory.repositories;

import co.develhope.librarymanagement.inventory.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
