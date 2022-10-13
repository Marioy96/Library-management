package co.develhope.librarymanagement.entities.inventory;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * Store è un punto vendita preciso.
 * Estende la classe PlaceOfWork, quindi ha varie informazioni anagrafiche tipo un nome, un indirizzo, etc.
 * Ogni punto vendita ha un suo magazzino di riferimento (Warehouse).
 */

@Entity
@Table(name = "stores")
public class Store extends PlaceOfWork {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    public Store(){}
    public Store(String name, String city, String address, LocalTime openingTime, LocalTime closingTime, Long id, Warehouse warehouse) {
        super(name, city, address, openingTime, closingTime);
        this.id = id;
        this.warehouse = warehouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
