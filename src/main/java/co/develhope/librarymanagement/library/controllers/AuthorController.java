package co.develhope.librarymanagement.library.controllers;


import co.develhope.librarymanagement.library.entities.Author;
import co.develhope.librarymanagement.library.services.AuthorService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @GetMapping("/getAllAuthors")
    public ResponseEntity<?> getAllAuthors() {
        try {
            logger.info("Getting all author");
            return ResponseEntity.status(HttpStatus.OK).body(authorService.getAllAuthors());
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getAuthorById")
    public ResponseEntity<?> getAuthorById(@RequestParam Long id) {
        try {
            logger.info("Getting author by Id");
            return ResponseEntity.status(HttpStatus.OK).body(authorService.findAuthorById(id));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping("/insertNewAuthor")
    public @ResponseBody ResponseEntity<?> insertNewAuthor(@RequestBody @NotNull Author newAuthor) {
       try{
           logger.info("Added a new Author");
           return ResponseEntity.status(HttpStatus.OK).body(authorService.insertNewAuthor(newAuthor));
       }catch (Exception e){
           logger.error(e.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }

    }

    @PutMapping("/updateAuthor")
    public @ResponseBody ResponseEntity<?> updateAuthor(@RequestBody @NotNull Author updatedAuthor, @RequestParam Long id) {
      try{
          logger.info("Update a Author");
          return  ResponseEntity.status(HttpStatus.OK).body(authorService.updateAuthor(id,updatedAuthor));
      } catch (Exception e) {
          logger.error(e.toString());
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
      }

    }

    @DeleteMapping("/deleteAuthorById")
    public ResponseEntity<?> deleteAuthor(@RequestParam Long id) {
       try{
           logger.info("Delete a author by id");
           return ResponseEntity.status(HttpStatus.OK).body(authorService.deleteAuthorById(id));
       }catch (Exception e){
           logger.error(e.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }

    @DeleteMapping("/deleteAllAuthor")
    public ResponseEntity<?> deleteAllAuthor(){
       try {
           logger.info("Delete All author");
           return ResponseEntity.status(HttpStatus.OK).body(authorService.deleteAllAuthor());
       }catch (Exception e){
           logger.error(e.toString());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }
    }


}
