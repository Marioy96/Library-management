package co.develhope.librarymanagement.repository;

import co.develhope.librarymanagement.entities.Stocktaking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocktakingRepository extends JpaRepository<Stocktaking,Integer> {
}
