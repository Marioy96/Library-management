package co.develhope.librarymanagement.library.repositories;

import co.develhope.librarymanagement.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
