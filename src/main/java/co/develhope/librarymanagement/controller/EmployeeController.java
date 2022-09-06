package co.develhope.librarymanagement.controller;


import co.develhope.librarymanagement.entities.Book;
import co.develhope.librarymanagement.entities.Employee;
import co.develhope.librarymanagement.entities.User;
import co.develhope.librarymanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @PostMapping("/InsertNewEmployee")
    public ResponseEntity<Employee> insertNewEmployee(@RequestBody Employee employee) {
        employeeService.insertNewEmployee(employee);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/deleteAll")
    public void deleteAllEmployee(){
        employeeService.deleteAllEmployee();
    }

    //TODO IMPLEMENT GET BY ID , DELETE BY ID , GET BY EMPLOYEE CODE, DELETE BY EMPLOYEE CODE




}
