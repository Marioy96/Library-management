package co.develhope.librarymanagement.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

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




