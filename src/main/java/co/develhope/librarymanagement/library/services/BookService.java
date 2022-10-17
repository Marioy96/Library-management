package co.develhope.librarymanagement.library.services;

import co.develhope.librarymanagement.library.entities.Author;
import co.develhope.librarymanagement.library.entities.Book;
import co.develhope.librarymanagement.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;

    public Book create(Book newBook,Long id) throws Exception {
        try{
            Optional<Author> author = authorService.findAuthorById(id);
            if(author.isPresent()){
                newBook.setAuthor(author.get());
                newBook.setId(newBook.getId());
                bookRepository.save(newBook);
            }
            return newBook;
        }catch (Exception e){
            throw new Exception("Incorrect input");
        }

    }

    public List<Book> findAll() throws Exception {
        List<Book> allBooksFromDb = bookRepository.findAll();
        if(allBooksFromDb.isEmpty()){
            throw new Exception("Not books found");
        }
        return allBooksFromDb;
    }

    public Optional<Book> findByISBN(String ISBN) throws Exception {
        try{
            return bookRepository.findByISBN(ISBN);
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }

    public Optional<Book> findById(Long id) throws Exception{
        try{
            return bookRepository.findById(id);
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }

    public Book update(Book book,Long id) throws Exception {
        if(!bookRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        book.setId(id);
        return bookRepository.save(book);
    }

    public String deleteAll() throws Exception {
        try{
            bookRepository.deleteAll();
            return "All book are deleted";
        }catch (Exception e){
            throw new Exception("Can't delete all book from db");
        }

    }

    public String deleteById(Long id) throws Exception {
       try {
           bookRepository.deleteById(id);
           return String.format("Book with id %d as delete", id);
       }catch (Exception e){
           throw new Exception("Book id not found");
       }
    }


}






