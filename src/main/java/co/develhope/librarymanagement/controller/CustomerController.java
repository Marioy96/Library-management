package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.Customer;
import co.develhope.librarymanagement.service.CustomerService;
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
    public Customer updateCustomer(@RequestBody Customer customer){
       return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCustomer(){
        customerService.deleteAllCustomer();
    }

    public void deleteCustomerById(Integer id){
        customerService.deleteCustomerById(id);
    }



}
