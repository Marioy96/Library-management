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

    public Optional<Customer> findById(Integer id){
        return customerRepository.findById(id);
    }

    public void deleteAllCustomer(){
        customerRepository.deleteAll();
    }

    public void deleteCustomerById(Integer id){
        customerRepository.deleteById(id);
    }



    public Customer updateCustomer(Customer customer) throws NullPointerException{
      Customer updateCustomer = customerRepository.findById(customer.getId()).orElse(null);
      try{
       updateCustomer.setTelephoneNumber(customer.getTelephoneNumber());
       updateCustomer.setEmail(customer.getEmail());
      }catch (NullPointerException ex){
          ex.printStackTrace();
      }
      return customerRepository.save(updateCustomer);
    }


}
