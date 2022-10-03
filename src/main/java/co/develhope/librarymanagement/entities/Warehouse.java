package co.develhope.librarymanagement.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "warehouse")
    private List<Stocktaking> stocktaking;

    @OneToMany(mappedBy = "warehouse")
    private Set<Store> stores;

    public Warehouse(){}
}


