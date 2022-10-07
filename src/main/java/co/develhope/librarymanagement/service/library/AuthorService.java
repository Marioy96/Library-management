package co.develhope.librarymanagement.service.library;

import co.develhope.librarymanagement.entities.library.Author;
import co.develhope.librarymanagement.repository.library.AuthorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() throws Exception {
        List<Author> allAuthorFromDb = authorRepository.findAll();
        if(allAuthorFromDb.isEmpty()){
            throw new Exception("Not authors found");
        }
        return allAuthorFromDb;
    }

    public Author insertNewAuthor(Author newAuthor) throws Exception {
         try{
             if(newAuthor == null) return null;
             return authorRepository.save(newAuthor);
         }catch (Exception e){
             throw new Exception("Incorrect input");
         }
    }

    public Optional<Author> findAuthorById(Long id) throws Exception {
        try {
            return authorRepository.findById(id);
        }catch (Exception e){
            throw new Exception("Id not found");
        }

    }

    public String deleteAllAuthor() throws Exception {
        try {
            authorRepository.deleteAll();
            return "All author as deleted";
        }catch (Exception e){
            throw new Exception("Can't delete all Author from db");
        }

    }

    public String deleteAuthorById(Long id) throws Exception {
        try{
            authorRepository.deleteById(id);
            return String.format("Author whit id %d as deleted ", id);
        }catch (Exception e){
            throw new Exception("Authors id not found");
        }


    }

    public Author updateAuthor(Long id, @NotNull Author author) throws Exception {
        if(!authorRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        author.setId(id);
        return authorRepository.save(author);
    }




}
