package co.develhope.librarymanagement.repository;

import co.develhope.librarymanagement.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {
    List<Employee> findAll();

    void save(Employee newEmployee);

    void deleteAll();
}
