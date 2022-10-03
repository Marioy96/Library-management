package co.develhope.librarymanagement.entities;

<<<<<<< HEAD

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "warehouse")
public class Warehouse {
=======
import javax.persistence.*;
import java.time.LocalDate;
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
>>>>>>> stocktaking-carlo

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

<<<<<<< HEAD
    @Column(name = "availability")
    private long availability;
    private int fkBook;

    //@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@JoinColumn(name = "books_id")
    //private List<Book> loan = new ArrayList<>();


    public Warehouse(){}
       public Warehouse(int id, long availability, int fkBook) {
        this.id = id;
        this.availability = availability;
        this.fkBook = fkBook;
       }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAvailability() {
        return availability;
    }

    public void setAvailability(long availability) {
        this.availability = availability;
    }

    public int getFkGioco() {
        return fkBook;
    }

    public void setFkGioco(int fkGioco) {
        this.fkBook = fkGioco;
    }
}




=======
    @OneToMany(mappedBy = "warehouse")
    private List<Stocktaking> stocktaking;

    @OneToMany(mappedBy = "warehouse")
    private Set<Store> stores;

}
>>>>>>> stocktaking-carlo
