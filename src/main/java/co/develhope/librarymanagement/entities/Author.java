package co.develhope.librarymanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

// Entity e Table sono annotazioni che informano Spring Data JPA che questa classe corrisponde ad una tabella
// nel database
@Entity
@Table(name="authors")
public class Author {

    // Id è un'annotazione che informa Spring Data JPA che id è chiave primaria di questa entità
    @Id
    // GeneratedValue chiede a Spring Data JPA di generare automaticamente un id crescente ogni volta che viene
    // inserito un nuovo autore nel DB
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    // Costruttore vuoto: obbligatorio per Spring Data JPA
    public Author() {
    }

    public Author(int id, String name, String surname, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
