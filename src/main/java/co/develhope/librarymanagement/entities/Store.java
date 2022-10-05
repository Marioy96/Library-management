package co.develhope.librarymanagement.entities;

import javax.persistence.*;

/**
 * Store è un punto vendita preciso.
 * Estende la classe PlaceOfWork, quindi ha varie informazioni anagrafiche tipo un nome, un indirizzo, etc.
 * Ogni punto vendita ha un suo magazzino di riferimento (Warehouse).
 */

@Entity
@Table(name = "stores")
public class Store extends PlaceOfWork{

    @Id
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
