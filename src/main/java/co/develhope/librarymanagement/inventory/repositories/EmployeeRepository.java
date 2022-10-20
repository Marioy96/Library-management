package co.develhope.librarymanagement.inventory.repositories;

import co.develhope.librarymanagement.inventory.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Optional<Employee> findByEmployeeCode(String employeeCode);

    long deleteByEmployeeCode(String employeeCode);


    Employee findByEmail(String email);

    Employee findByActivationCode(String activationCode);

}



