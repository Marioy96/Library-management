package co.develhope.librarymanagement.repository;

import co.develhope.librarymanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // ho rimosso i metodi che avevi aggiunto e avevi dimenticato di esternder la classe JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
