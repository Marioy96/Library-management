package co.develhope.librarymanagement.entities.inventory;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Ci possono essere vari tipi di luoghi di lavoro: il magazzino, il negozio, un ufficio, etc.
 * Ogni luogo di lavoro estende questa classe, da cui eredita caratteristiche comuni (es l'indirizzo).
 *
 */
@MappedSuperclass
public class PlaceOfWork {

    private String name;
    private String city;
    private String address;
    private LocalTime openingTime;
    private LocalTime closingTime;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_of_work_ID")
    private Set<Employee> employees = new LinkedHashSet<>();*/

  /*  public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }*/

    public PlaceOfWork() {
    }
    public PlaceOfWork(String name, String city, String address, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
}

