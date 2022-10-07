package co.develhope.librarymanagement.repository.library;

import co.develhope.librarymanagement.entities.library.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
