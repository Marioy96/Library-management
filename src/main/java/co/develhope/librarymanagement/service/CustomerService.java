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
       if(customer == null) return null;
       return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public String deleteAllCustomer(){
        customerRepository.deleteAll();
        return "All author as deleted";
    }

    public Customer updateCustomer(Customer customer,Integer id) throws Exception {
        if(!customerRepository.existsById(id)){
            throw new Exception("id doesn't exist");
        }
        return customerRepository.save(customer);
    }

    public String deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
        return String.format("Customer whit id %d as deleted", id);
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);

    }
}