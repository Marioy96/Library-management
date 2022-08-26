package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.Customer;
import co.develhope.librarymanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void insertNewCustomer(@RequestBody Customer customer){
        //TODO Respond with OK message and handle errors
        customerService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCustomer(){
        customerService.deleteAllCustomer();
    }


}
