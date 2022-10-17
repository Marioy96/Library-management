package co.develhope.librarymanagement.inventory.repositories;

import co.develhope.librarymanagement.inventory.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
}
