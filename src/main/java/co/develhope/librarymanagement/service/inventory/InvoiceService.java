package co.develhope.librarymanagement.service.inventory;

import co.develhope.librarymanagement.entities.inventory.Invoice;
import co.develhope.librarymanagement.entities.library.Book;
import co.develhope.librarymanagement.entities.library.Customer;
import co.develhope.librarymanagement.entities.library.User;
import co.develhope.librarymanagement.repository.inventory.InvoiceRepository;
import co.develhope.librarymanagement.service.library.BookService;
import co.develhope.librarymanagement.service.library.CustomerService;
import co.develhope.librarymanagement.service.library.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Invoice create(Invoice invoice,Integer customerId,Integer bookId,Integer userId) throws Exception {
        try{
            Optional<Customer> customer = customerService.findById(customerId);
            Optional<Book> book = bookService.findBookById(bookId);
            Optional<User> user = userService.findUserById(userId);
            if(customer.isPresent() && book.isPresent() && user.isPresent()){
                invoice.setBook(book.get());
                invoice.setCustomer(customer.get());
                invoice.setUser(user.get());
                invoice.setTotalPrice(book.get().getPrice());
                invoiceRepository.save(invoice);
            }
            return invoice;
        } catch (Exception e) {
            throw new Exception("Incorrect input");
        }
    }

    public Invoice update(Integer id, Invoice invoice) throws Exception {
        if(!invoiceRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        invoice.setId(id);
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoice() throws Exception {
      List<Invoice> invoices = invoiceRepository.findAll();
      if(invoices.isEmpty()){
          throw new Exception("Not invoice found");
      }
      return invoices;
    }

    public Optional<Invoice> getSingle(Integer id) throws Exception {
       try{
           return invoiceRepository.findById(id);
       }catch (Exception e){
        throw new Exception("Store id not found");
       }
    }

    public String deleteAll() throws Exception {
        try{
            invoiceRepository.deleteAll();
            return "All invoice are deleted";
        }catch (Exception e){
            throw new Exception("Can't delete invoices from db");
        }
    }

    public String deleteSingle(Integer id) throws Exception {
        try {
            invoiceRepository.deleteById(id);
            return String.format("Invoice with id %d as delete", id);
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }






}
