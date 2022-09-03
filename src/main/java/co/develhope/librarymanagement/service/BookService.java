package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Book;
import co.develhope.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAllBook() {
        return bookRepository.findAll();}


    public void insertNewBook(Book newBook) {
        bookRepository.save(newBook);
    }

    public void deleteAllBook() {
        bookRepository.deleteAll();
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}






