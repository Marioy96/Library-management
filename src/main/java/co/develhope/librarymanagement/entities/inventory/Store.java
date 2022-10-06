package co.develhope.librarymanagement.entities.inventory;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

/**
 * Store è un punto vendita preciso.
 * Estende la classe PlaceOfWork, quindi ha varie informazioni anagrafiche tipo un nome, un indirizzo, etc.
 * Ogni punto vendita ha un suo magazzino di riferimento (Warehouse).
 */

@Entity
@Table(name = "stores")
public class Store extends PlaceOfWork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    public Store(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
