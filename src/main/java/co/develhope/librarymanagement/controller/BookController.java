package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.entities.Book;


import co.develhope.librarymanagement.service.AuthorService;
import co.develhope.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

   @GetMapping("/getAllBook")
    public List<Book> getAllBook(){
        return bookService.findAllBook();
    }

    @PostMapping("/InsertNewBook")
    public ResponseEntity<Book> insertNewBook(@RequestBody Book book,@RequestParam Integer id) {
        Optional<Author> author = authorService.findAuthorById(id);
        if(author.isPresent()){
          book.setAuthor(author.get());
            bookService.insertNewBook(book);
            return new ResponseEntity<Book>(book,HttpStatus.ACCEPTED);
        }
        else {
           return new ResponseEntity("Author id not found",HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/updateUser")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return new ResponseEntity(book,HttpStatus.OK);
    }

    @DeleteMapping("/DeleteBook")
    public ResponseEntity<Book> deleteAllBook(){
        bookService.deleteAllBook();
        return new ResponseEntity(HttpStatus.OK);
    }

















}
