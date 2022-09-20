package co.develhope.librarymanagement.repository;

import co.develhope.librarymanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    Optional<Employee> findByEmployeeCode(String employeeCode);

    long deleteByEmployeeCode(String employeeCode);


}



