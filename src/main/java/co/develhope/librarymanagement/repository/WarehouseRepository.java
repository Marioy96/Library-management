package co.develhope.librarymanagement.repository;

import co.develhope.librarymanagement.entities.Book;
import co.develhope.librarymanagement.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

}



