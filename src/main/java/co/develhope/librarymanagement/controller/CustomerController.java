package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.Customer;
import co.develhope.librarymanagement.repository.CustomerRepository;
import co.develhope.librarymanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer(){
       return customerService.findAllCustomer();
    }

    //TODO implement get by Id


    @PostMapping("/postCustomer")
    public void insertNewCustomer(@RequestBody Customer customer){
        //TODO Respond with OK message and handle errors
        customerService.addCustomer(customer);
    }


}
