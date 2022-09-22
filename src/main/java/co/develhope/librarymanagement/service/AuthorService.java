package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.entities.Author;
import co.develhope.librarymanagement.repository.AuthorRepository;
import org.jetbrains.annotations.NotNull;
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

    public Author insertNewAuthor(Author newAuthor) {
         if(newAuthor == null) return null;
         return authorRepository.save(newAuthor);
    }

    public Optional<Author> findAuthorById(Integer id){
         return authorRepository.findById(id);
    }

    public String deleteAllAuthor(){
        authorRepository.deleteAll();
        return "All author as deleted";
    }

    public String deleteAuthorById(@NotNull Integer id){
        authorRepository.deleteById(id);
        return String.format("Author whit id %d as deleted ", id);

    }

    public Author updateAuthor(Integer id, @NotNull Author author) throws Exception {
        if(!authorRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        return authorRepository.save(author);
    }




}
