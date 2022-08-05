package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void insertNewAuthor(Author newAuthor) {
        authorRepository.save(newAuthor);
    }

}
