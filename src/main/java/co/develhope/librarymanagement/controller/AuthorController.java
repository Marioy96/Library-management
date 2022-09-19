package co.develhope.librarymanagement.controller;


import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * AuthorController contains all the APIs necessary to interact with Author entity.
 * Allows to perform all CRUD operations on Author entity:
 * * Create
 * * Read
 * * Update
 * * Delete
 */

// TODO ricordatevi di cambiare i dati di accesso al database nell file properties altrimenti non funziona nulla!!

// This annotation informs Spring Data JPA that this Class is a Controller for a REST API
@RestController
// "/authors" is the root for all the addresses in this API
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;



    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }


    @GetMapping("/getAuthorById")
    public ResponseEntity<Optional<Author>> getAuthorById(@RequestParam int id) {
        authorService.findAuthorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertNewAuthor")
    public ResponseEntity<Author> insertNewAuthor(@RequestBody Author newAuthor) {
        authorService.insertNewAuthor(newAuthor);
        return new ResponseEntity<Author>(newAuthor, HttpStatus.OK);
    }

    @PutMapping("/")
    public  ResponseEntity<Author> updateAuthor(@RequestBody Author updatedAuthor) {
        authorService.updateAuthor(updatedAuthor);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/deleteAuthor")
    public ResponseEntity <Author> deleteAuthor(@RequestParam int id) {
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllAuthor")
    public ResponseEntity<Author> deleteAllAuthor(){
        authorService.deleteAllAuthor();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
