package co.develhope.librarymanagement.repository;

import co.develhope.librarymanagement.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {
}
