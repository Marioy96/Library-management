package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// TODO implementare i metodi crud nel service,per gli esempi guarda la classe AuthorService
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
}
