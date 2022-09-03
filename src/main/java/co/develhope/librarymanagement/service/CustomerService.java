package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Customer;
import co.develhope.librarymanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public void deleteAllCustomer(){
        customerRepository.deleteAll();
    }

    public Customer updateCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }


    public void deleteCustomerById(Integer id) {
    }


}