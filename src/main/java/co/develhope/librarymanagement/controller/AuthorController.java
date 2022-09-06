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

    // TODO Fetch author by id
    // Get author by Id because we can have more authors with the same name
    @GetMapping("/getAuthorById")
    public Optional<Author> getAuthorById(@RequestParam int id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping("/insertNewAuthor")
    public ResponseEntity<Author> insertNewAuthor(@RequestBody Author newAuthor) {
        authorService.insertNewAuthor(newAuthor);
        return new ResponseEntity<Author>(newAuthor, HttpStatus.ACCEPTED);
    }

    /*
    Possibilità 1: una sola funzione di aggiornamento che prende in ingresso un autore completo e lo sovrascrive
                    a quello precedente;
    Possibilità 2: una funzione per ogni campo da modificare: "/updateAuthorName", "/updateAuthorSurname", ecc
     */
    @PutMapping("/")
    public void updateAuthor(@RequestBody Author updatedAuthor) {
        // TODO Update author informations
    }

    @DeleteMapping("/deleteAuthor")
    public void deleteAuthor(@RequestParam int id) {
        authorService.deleteAuthorById(id);
    }

    @DeleteMapping("/deleteAllAuthor")
    public void deleteAllAuthor(){
        authorService.deleteAllAuthor();
    }


}
