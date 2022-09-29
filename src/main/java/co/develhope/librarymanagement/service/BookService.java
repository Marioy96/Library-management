package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Book;
import co.develhope.librarymanagement.repository.BookRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAllBook() throws Exception {
        List<Book> allBooksFromDb = bookRepository.findAll();
        if(allBooksFromDb.isEmpty()){
            throw new Exception("Not books found");
        }
        return allBooksFromDb;
    }



    public Book insertNewBook(Book newBook) throws Exception {
        try{
            newBook.setId(null);
            return bookRepository.save(newBook);
        }catch (Exception e){
            throw new Exception("Incorrect input ");
        }

    }

    public String deleteAllBook() throws Exception {
        try{
            bookRepository.deleteAll();
            return "All book are deleted";
        }catch (Exception e){
            throw new Exception("Can't delete all book from db");
        }

    }

    public Book updateBook(Book book,Integer id) throws Exception {
        if(!bookRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        return bookRepository.save(book);
    }

    public String deleteBookById(@NotNull Integer id) throws Exception {
       try {
           bookRepository.deleteById(id);
           return String.format("Book with id %d as delete", id);
       }catch (Exception e){
           throw new Exception("Book id not found");
       }
    }
}






