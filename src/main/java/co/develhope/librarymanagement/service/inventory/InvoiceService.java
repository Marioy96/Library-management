package co.develhope.librarymanagement.service.inventory;

import co.develhope.librarymanagement.repository.inventory.InvoiceRepository;
import co.develhope.librarymanagement.service.library.BookService;
import co.develhope.librarymanagement.service.library.CustomerService;
import co.develhope.librarymanagement.service.library.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;






}
