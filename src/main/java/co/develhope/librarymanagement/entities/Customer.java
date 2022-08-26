package co.develhope.librarymanagement.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String surname;
    private String telephoneNumber;
    private String email;
    private Boolean turnAvailability;
    private LocalDate absences;

    public Customer(int id, String name, String surname, String telephoneNumber, String email, Boolean turnAvailability, LocalDate absences) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.turnAvailability = turnAvailability;
        this.absences = absences;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTurnAvailability() {
        return turnAvailability;
    }

    public void setTurnAvailability(Boolean turnAvailability) {
        this.turnAvailability = turnAvailability;
    }

    public LocalDate getAbsences() {
        return absences;
    }

    public void setAbsences(LocalDate absences) {
        this.absences = absences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}


