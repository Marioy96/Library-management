package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.entities.Book;
import co.develhope.librarymanagement.repository.BookRepository;
import org.jetbrains.annotations.NotNull;
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

    public List<Book> findAllBook() throws Exception {
        List<Book> allBooksFromDb = bookRepository.findAll();
        if(allBooksFromDb.isEmpty()){
            throw new Exception("Not books found");
        }
        return allBooksFromDb;
    }

    public Book insertNewBook(Book newBook,Integer id) throws Exception {
        try{
            Optional<Author> author = authorService.findAuthorById(id);
            if(author.isPresent()){
                newBook.setAuthor(author.get());
                bookRepository.save(newBook);
            }
            return newBook;
        }catch (Exception e){
            throw new Exception("Incorrect input");
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

    public Optional<Book> findBookById(Integer id) throws Exception{
        try{
            return bookRepository.findById(id);
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }
}






