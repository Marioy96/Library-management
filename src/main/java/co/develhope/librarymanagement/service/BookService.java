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

    public List<Book> findAllBook() {
        return bookRepository.findAll();}


    public Book insertNewBook(Book newBook) {
       return bookRepository.save(newBook);
    }

    public String deleteAllBook() {
        bookRepository.deleteAll();
        return "All book are deleted";
    }

    public Book updateBook(Book book,Integer id) throws Exception {
        if(!bookRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        return bookRepository.save(book);
    }

    public String deleteBookById(@NotNull Integer id){
        bookRepository.deleteById(id);
        return String.format("Book whti id %d as delete",id);
    }
}






