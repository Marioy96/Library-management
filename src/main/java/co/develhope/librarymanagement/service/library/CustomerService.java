package co.develhope.librarymanagement.service.library;

import co.develhope.librarymanagement.entities.library.Customer;
import co.develhope.librarymanagement.repository.library.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) throws Exception {
      try {
          if (customer == null) return null;
          return customerRepository.save(customer);
      }catch (Exception e){
          throw new Exception("Incorrect input");
      }
    }

    public List<Customer> findAllCustomer() throws Exception {
        List<Customer> allCustomerFromDb = customerRepository.findAll();
        if(allCustomerFromDb.isEmpty()){
            throw new Exception("Not authors find");
        }
        return  allCustomerFromDb;
    }

    public String deleteAllCustomer() throws Exception{
       try {
           customerRepository.deleteAll();
           return "All author as deleted";
       }catch (Exception e){
          throw new Exception("Can't delete all customer from db");
       }
    }

    public Customer updateCustomer(Customer customer,Long id) throws Exception {
        if(!customerRepository.existsById(id)){
            throw new Exception("id doesn't exist");
        }
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public String deleteCustomerById(Long id) throws Exception {
       try {
           customerRepository.deleteById(id);
           return String.format("Customer whit id %d as deleted", id);
       }catch (Exception e){
           throw new Exception("Customer id not found");
       }
    }

    public Optional<Customer> findById(Long id) throws Exception {
        try{
            return customerRepository.findById(id);
        }catch (Exception e){
            throw new Exception("Customer id not found");
        }
    }
}