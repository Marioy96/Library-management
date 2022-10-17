package co.develhope.librarymanagement.inventory.repositories;

import co.develhope.librarymanagement.inventory.entities.Stocktaking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocktakingRepository extends JpaRepository<Stocktaking,Long> {
}
