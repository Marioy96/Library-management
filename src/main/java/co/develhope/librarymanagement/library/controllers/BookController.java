package co.develhope.librarymanagement.library.controllers;

import co.develhope.librarymanagement.library.entities.Book;


import co.develhope.librarymanagement.library.services.BookService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @PostMapping("/create")
    public ResponseEntity<?> insertNewBook(@RequestBody @NotNull Book book, @RequestParam Long authorId) throws Exception {
        try{
            logger.info("Create a book");
            return ResponseEntity.status(HttpStatus.OK).body(bookService.create(book,authorId));
        }catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
   @GetMapping("/getAllBook")
    public ResponseEntity<?> getAllBook(){
        try {
            logger.info("Getting all book");
            return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
   }

   @GetMapping("/getBookById")
   public ResponseEntity<?> getBookById(@RequestParam Long id){
       try {
           logger.info("Get book by id");
           return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
       } catch (Exception e) {
           logger.error(e.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
   }

    @GetMapping("/getByISBN")
    public ResponseEntity<?> getBookById(@RequestParam String ISBN){
        try {
            logger.info("Get book by id");
            return ResponseEntity.status(HttpStatus.OK).body(bookService.findByISBN(ISBN));
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@RequestBody @NotNull Book book, @RequestParam Long id) {
       try{
           logger.info("Update a book");
           return ResponseEntity.status(HttpStatus.OK).body(bookService.update(book, id));
       } catch (Exception e) {
           logger.error(e.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAllBook(){
     try {
         logger.info("Delete all book");
         return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteAll());
     } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
     }
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteAuthorById(@RequestParam Long id){
       try {
           logger.info("delete author by id");
           return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteById(id));
       } catch (Exception e) {
         logger.error(e.toString());
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

















}
