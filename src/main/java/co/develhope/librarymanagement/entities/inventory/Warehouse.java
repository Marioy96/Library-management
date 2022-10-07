package co.develhope.librarymanagement.entities.inventory;


import co.develhope.librarymanagement.entities.inventory.PlaceOfWork;
import co.develhope.librarymanagement.entities.inventory.Stocktaking;
import co.develhope.librarymanagement.entities.inventory.Store;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

/**
 * Warehouse è un magazzino che può rifornire più di un punto vendita.
 * Estende la classe PlaceOfWork, quindi ha varie informazioni anagrafiche tipo un nome, un indirizzo, etc.
 * Ogni magazzino ha vari inventari - uno per ogni libro -, che tengono il conto delle copie disponibili di quel libro.
 * Ogni magazzino ha una lista di punti vendita che rifornisce.
 */

@Entity
@Table(name = "warehouse")
public class Warehouse extends PlaceOfWork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "warehouse")
    private List<Stocktaking> stocktaking;

    @OneToMany(mappedBy = "warehouse")
    private Set<Store> stores;

    public Warehouse(){}

    public Warehouse(String name, String city, String address, LocalTime openingTime, LocalTime closingTime, Long id, List<Stocktaking> stocktaking, Set<Store> stores) {
        super(name, city, address, openingTime, closingTime);
        this.id = id;
        this.stocktaking = stocktaking;
        this.stores = stores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Stocktaking> getStocktaking() {
        return stocktaking;
    }

    public void setStocktaking(List<Stocktaking> stocktaking) {
        this.stocktaking = stocktaking;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }
}


