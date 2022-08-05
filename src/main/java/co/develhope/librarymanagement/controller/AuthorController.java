package co.develhope.librarymanagement.controller;


import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * AuthorController contains all the APIs necessary to interact with Author entity.
 * Allows to perform all CRUD operations on Author entity:
 * * Create
 * * Read
 * * Update
 * * Delete
 */

// This annotation informs Spring Data JPA that this Class is a Controller for a REST API
@RestController
// "/authors" is the root for all the addresses in this API
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    // TODO Fetch all authors from the database
    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors() {
        return new ArrayList<>();
    }

    // TODO Fetch author by id
    // Get author by Id because we can have more authors with the same name
    @GetMapping("/getAuthorById")
    public Author getAuthorById(@RequestParam int id) {
        return new Author();
    }

    @PostMapping("/insertNewAuthor")
    public void insertNewAuthor(@RequestBody Author newAuthor) {
        // TODO Respond with OK message and handle errors
        authorService.insertNewAuthor(newAuthor);
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
        // TODO Delete author from DB
    }


}
