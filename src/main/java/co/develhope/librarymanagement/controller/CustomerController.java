package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.entities.Customer;
import co.develhope.librarymanagement.service.CustomerService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/getAllCustomer")
    public ResponseEntity getAllCustomer(){
        try{
            logger.info("Getting all customer");
            return ResponseEntity.status(HttpStatus.OK).body(customerService.findAllCustomer());
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getById")
    public ResponseEntity getById(@RequestParam Integer id){
      try {
          logger.info("Getting customer by Id");
          return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
      }catch (Exception e){
          logger.error(e.toString());
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
      }
    }

    @PostMapping("/postCustomer")
    public @ResponseBody ResponseEntity insertNewCustomer(@RequestBody @NotNull Customer customer){
        try{
            logger.info("Added new customer");
            return ResponseEntity.status(HttpStatus.OK).body(customerService.addCustomer(customer));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity updateCustomer(@RequestBody Customer customer,@RequestParam Integer id){
        try{
            logger.info("Update a customer");
            return  ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customer,id));
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllCustomer(){
        try {
            logger.info("Delete all customer");
            return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteAllCustomer());
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity  deleteCustomerById(Integer id){
        try{
            logger.info("Delete a customer by id");
            return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomerById(id));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }



}
