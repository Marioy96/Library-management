package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void insertNewAuthor(Author newAuthor) {
        authorRepository.save(newAuthor);
    }

    public Optional<Author> findAuthorById(Integer id){
         return authorRepository.findById(id);
    }
    public void deleteAllAuthor(){
        authorRepository.deleteAll();
    }

    public void deleteAuthorById(Integer id){
        authorRepository.deleteById(id);
    }




}
