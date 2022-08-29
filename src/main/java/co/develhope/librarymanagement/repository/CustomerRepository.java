package co.develhope.librarymanagement.repository;

import co.develhope.librarymanagement.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    long countByAbsences(LocalDate absences);
}
