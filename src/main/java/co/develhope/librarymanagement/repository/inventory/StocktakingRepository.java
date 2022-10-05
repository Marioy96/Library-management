package co.develhope.librarymanagement.repository.inventory;

import co.develhope.librarymanagement.entities.inventory.Stocktaking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocktakingRepository extends JpaRepository<Stocktaking,Integer> {
}
