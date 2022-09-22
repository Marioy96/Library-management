package co.develhope.librarymanagement.controller;


import co.develhope.librarymanagement.entities.Book;
import co.develhope.librarymanagement.entities.Employee;
import co.develhope.librarymanagement.entities.User;
import co.develhope.librarymanagement.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        employeeService.getAllEmployee();
        return new ResponseEntity <List<Employee>>(HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<Employee> getEmployeeById(Integer id){
        employeeService.getEmployeeById(id);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }

    @GetMapping("/getEmployeeByCode")
    public ResponseEntity<Employee> getEmployeeByCode(String code){
        employeeService.getEmployeeByCode(code);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }

    @PostMapping("/InsertNewEmployee")
    public ResponseEntity<Employee> insertNewEmployee(@RequestBody Employee employee) {
        employeeService.insertNewEmployee(employee);
        return new ResponseEntity<Employee>(employee,HttpStatus.OK);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Employee> deleteAllEmployee(){
        employeeService.deleteAllEmployee();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Employee> deleteById(Integer id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteByCode")
    public ResponseEntity<Employee> deleteByEmployeeCode(String code){
        employeeService.deleteEmployeeByCode(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
