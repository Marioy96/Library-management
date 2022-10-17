package co.develhope.librarymanagement.library.repositories;


import co.develhope.librarymanagement.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByISBN(String ISBN);

}
