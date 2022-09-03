package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.Book;


import co.develhope.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

   @GetMapping("/getAllBook")
    public List<Book> getAllBook(){
        return bookService.findAllBook();
    }

    @PostMapping("/InsertNewBook")
    public ResponseEntity<Book> insertNewBook(@RequestBody Book book) {
        bookService.insertNewBook(book);
        return new ResponseEntity<Book>(HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    @DeleteMapping("/DeleteBook")
    public void deleteAllBook(){
        bookService.deleteAllBook();
    }

















}
