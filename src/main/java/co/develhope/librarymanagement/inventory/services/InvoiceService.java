package co.develhope.librarymanagement.inventory.services;

import co.develhope.librarymanagement.inventory.entities.Invoice;
import co.develhope.librarymanagement.library.entities.Book;
import co.develhope.librarymanagement.library.entities.User;
import co.develhope.librarymanagement.inventory.repositories.InvoiceRepository;
import co.develhope.librarymanagement.library.services.BookService;
import co.develhope.librarymanagement.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    public Invoice create(Invoice invoice,Long bookId,Long userId) throws Exception {
        try{

            Optional<Book> book = bookService.findById(bookId);
            Optional<User> user = userService.findUserById(userId);
            if(book.isPresent() && user.isPresent()){
                invoice.setBook(book.get());
                invoice.setUser(user.get());
                invoice.setTotalPrice(book.get().getPrice());
                invoiceRepository.save(invoice);
            }
            return invoice;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Incorrect input");
        }
    }

    public Invoice update(Long id, Invoice invoice) throws Exception {
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

    public Optional<Invoice> getSingle(Long id) throws Exception {
       try{
           return invoiceRepository.findById(id);
       }catch (Exception e){
           e.printStackTrace();
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

    public String deleteSingle(Long id) throws Exception {
        try {
            invoiceRepository.deleteById(id);
            return String.format("Invoice with id %d as delete", id);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Id not found");
        }
    }






}
