package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Employee;
import co.develhope.librarymanagement.repository.EmployeeRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() throws Exception {
        List <Employee> allEmployees = employeeRepository.findAll();
        if(allEmployees.isEmpty()){
            throw new Exception("Not employee found");
        }
        return allEmployees;
    }

    public Employee insertNewEmployee(Employee newEmployee) throws Exception {
       try {
           if (newEmployee == null) return null;
           return employeeRepository.save(newEmployee);
       }catch (Exception e){
           throw new Exception("Incorrect Input");
       }
    }

    public String deleteAllEmployee() throws Exception {
       try {
           employeeRepository.deleteAll();
           return "All employee al deleted";
       }catch (Exception e){
           throw new Exception("Can't delete all employee from db");
       }
    }

    public Employee updateEmployee(@NotNull Employee employee, Integer id) throws Exception {
        if(!employeeRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        return employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Integer id) throws Exception {
       try {
           return employeeRepository.findById(id);
       }catch (Exception e){
           throw new Exception("Id not found");
       }

    }

    public Optional<Employee> getEmployeeByCode(String code) throws Exception {
       try {
           return employeeRepository.findByEmployeeCode(code);
       }catch (Exception e){
           throw new Exception("Employee code not found");
       }
    }

    public String deleteEmployeeById(Integer id) throws Exception {
       try {
           employeeRepository.deleteById(id);
           return String.format("Employee whit id %d as deleted ", id);
       }catch (Exception e){
           throw new Exception("Employee id not found");
       }

    }

    public String deleteEmployeeByCode(String code) throws Exception {
       try {
           employeeRepository.deleteByEmployeeCode(code);
           return String.format("Author whit id %s as deleted ", code);
       }catch (Exception e){
           throw new Exception("Employee code not found");
       }
    }



}
