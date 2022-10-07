package co.develhope.librarymanagement.repository.library;

import co.develhope.librarymanagement.entities.library.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    long countByAbsences(LocalDate absences);
}
