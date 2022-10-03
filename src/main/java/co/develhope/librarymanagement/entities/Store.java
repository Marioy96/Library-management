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
    private int id;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

}
