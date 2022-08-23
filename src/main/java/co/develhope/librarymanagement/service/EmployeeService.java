package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Employee;
import co.develhope.librarymanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO implementare i metodi crud nel service,per gli esempi guarda la classe AuthorService
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void insertNewEmployee(Employee newEmployee) {
        employeeRepository.save(newEmployee);
    }

    public void deleteAllEmployee(){employeeRepository.deleteAll();
    }

    public void updateEmployee(Employee employee){employeeRepository.save(new Employee());
    }






}
