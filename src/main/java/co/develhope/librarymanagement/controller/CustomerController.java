package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.entities.Customer;
import co.develhope.librarymanagement.service.CustomerService;
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
    public List<Customer> getAllCustomer(){
       return customerService.findAllCustomer();
    }

    @GetMapping("/getById")
    public Optional<Customer> getById(@RequestParam Integer id){
      return customerService.findById(id);
    }

    @PostMapping("/postCustomer")
    public ResponseEntity<Customer> insertNewCustomer(@RequestBody Customer customer){
         customerService.addCustomer(customer);
         return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
       customerService.updateCustomer(customer);
       return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity <Customer>deleteAllCustomer(){
        customerService.deleteAllCustomer();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Customer> deleteCustomerById(Integer id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }



}
