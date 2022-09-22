package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.entities.Book;


import co.develhope.librarymanagement.service.AuthorService;
import co.develhope.librarymanagement.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(BookController.class);

   @GetMapping("/getAllBook")
    public ResponseEntity getAllBook(){
        try {
            logger.info("Getting all book");
            return ResponseEntity.status(HttpStatus.OK).body(bookService.findAllBook());
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
   }

    @PostMapping("/InsertNewBook")
    public @ResponseBody ResponseEntity insertNewBook(@RequestBody @NotNull Book book, @RequestParam Integer id) {
        Optional<Author> author = authorService.findAuthorById(id);
        if(author.isPresent()){
          book.setAuthor(author.get());
            logger.info("Insert a new book");
            return ResponseEntity.status(HttpStatus.OK).body(bookService.insertNewBook(book));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/updateBook")
    public @ResponseBody ResponseEntity updateBook(@RequestBody @NotNull Book book, @RequestParam Integer id) {
       try{
           logger.info("Update a book");
           return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(book, id));
       } catch (Exception e) {
           logger.error(e.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity deleteAllBook(){
     try {
         logger.info("Delete all book");
         return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteAllBook());
     } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
     }
    }

    @DeleteMapping("/deleteBookById")
    public ResponseEntity deleteAuthorById(@RequestParam int id){
       try {
           logger.info("delete author by id");
           return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBookById(id));
       } catch (Exception e) {
         logger.error(e.toString());
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

















}
