package co.develhope.librarymanagement.repository.library;

import co.develhope.librarymanagement.entities.library.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
