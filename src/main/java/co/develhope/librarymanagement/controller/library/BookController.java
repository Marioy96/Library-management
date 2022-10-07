package co.develhope.librarymanagement.controller.library;

import co.develhope.librarymanagement.entities.library.Book;


import co.develhope.librarymanagement.service.library.BookService;
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

   @GetMapping("/getBookById")
   public ResponseEntity getBookById(@RequestParam Long id){
       try {
           logger.info("Get book by id");
           return ResponseEntity.status(HttpStatus.OK).body(bookService.findBookById(id));
       } catch (Exception e) {
           logger.error(e.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
   }

    @PostMapping("/InsertNewBook")
    public @ResponseBody ResponseEntity insertNewBook(@RequestBody @NotNull Book book, @RequestParam Long id) throws Exception {
        try{
            logger.info("Create a book");
            return ResponseEntity.status(HttpStatus.OK).body(bookService.insertNewBook(book,id));
        }catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/updateBook")
    public @ResponseBody ResponseEntity updateBook(@RequestBody @NotNull Book book, @RequestParam Long id) {
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
    public ResponseEntity deleteAuthorById(@RequestParam Long id){
       try {
           logger.info("delete author by id");
           return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBookById(id));
       } catch (Exception e) {
         logger.error(e.toString());
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

















}
