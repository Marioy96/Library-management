package co.develhope.librarymanagement.entities;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * Ci possono essere vari tipi di luoghi di lavoro: il magazzino, il negozio, un ufficio, etc.
 * Ogni luogo di lavoro estende questa classe, da cui eredita caratteristiche comuni (es l'indirizzo).
 *
 */
@MappedSuperclass
public class PlaceOfWork {

    @OneToMany(mappedBy = "placeOfWork")
    private List<Employee> employeeList;

    private String name;
    private String city;
    private String address;
    private LocalTime openingTime;
    private LocalTime closingTime;

}

