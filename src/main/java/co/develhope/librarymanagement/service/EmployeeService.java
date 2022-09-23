package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Employee;
import co.develhope.librarymanagement.repository.EmployeeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// TODO implementare i metodi crud nel service,per gli esempi guarda la classe AuthorService
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee insertNewEmployee(Employee newEmployee) {
       if(newEmployee == null) return null;
       return employeeRepository.save(newEmployee);
    }

    public String deleteAllEmployee(){
        employeeRepository.deleteAll();
        return "All employee al deleted";
    }

    public Employee updateEmployee(@NotNull Employee employee, Integer id) throws Exception {
        if(!employeeRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id){
       return employeeRepository.findById(id);

    }

    public Optional<Employee> getEmployeeByCode(String code){
        return employeeRepository.findByEmployeeCode(code);
    }

    public String deleteEmployeeById(Integer id){
        employeeRepository.deleteById(id);
        return String.format("Employee whit id %d as deleted ", id);
    }

    public String deleteEmployeeByCode(String code){
        employeeRepository.deleteByEmployeeCode(code);
        return String.format("Author whit id %s as deleted ", code);
    }



}
