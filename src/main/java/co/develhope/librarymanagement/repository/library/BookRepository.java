package co.develhope.librarymanagement.repository.library;


import co.develhope.librarymanagement.entities.library.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
