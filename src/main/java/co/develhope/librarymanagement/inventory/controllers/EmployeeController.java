package co.develhope.librarymanagement.inventory.controllers;


import co.develhope.librarymanagement.inventory.entities.Employee;
import co.develhope.librarymanagement.inventory.services.EmployeeService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/getAllEmployee")
    public ResponseEntity<?> getAllEmployee(){
       try{
           logger.info("Getting all employee");
           return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
       }catch (Exception e){
           logger.error(e.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

    @GetMapping("/getEmployeeById")
    public ResponseEntity<?> getEmployeeById(@RequestParam Long id){
        try{
            logger.info("Getting employee by id");
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getEmployeeByCode")
    public ResponseEntity<?> getEmployeeByCode(String code){
        try{
            logger.info("Getting employee by employee code");
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeByCode(code));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/InsertNewEmployee")
    public @ResponseBody ResponseEntity<?> insertNewEmployee(@RequestBody @NotNull Employee employee) {
        try{
            logger.info("Insert employee");
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.create(employee));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @RequestParam Long id) {
        try{
            logger.info("Update a employee");
            return  ResponseEntity.status(HttpStatus.OK).body(employeeService.update(employee,id));
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/placeOfWork")
    public ResponseEntity<?> setPlaceOfWork(@RequestParam String employeeCode, @RequestParam Long placeOfWorkId){
        try{
            logger.info("Update a employee");
            return  ResponseEntity.status(HttpStatus.OK).body(employeeService.setPlaceOfWork(employeeCode, placeOfWorkId));
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllEmployee(){
        try {
            logger.info("Delete all employee");
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteAllEmployee());
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(Long id){
        try {
            logger.info("Delete employee by id");
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmployeeById(id));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteByCode")
    public ResponseEntity<?> deleteByEmployeeCode(String code){
        try {
            logger.info("Delete all employee");
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteByCode(code));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }






}
