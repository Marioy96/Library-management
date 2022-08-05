package co.develhope.librarymanagement.repository;

import co.develhope.librarymanagement.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
