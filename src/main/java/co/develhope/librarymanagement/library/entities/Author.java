package co.develhope.librarymanagement.library.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

// Entity e Table sono annotazioni che informano Spring Data JPA che questa classe corrisponde ad una tabella
// nel database
@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Integer numberOfBookWrited;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "author_id")
    private Set<Book> books = new LinkedHashSet<>();


    public Author() {
    }

    public Author(Long id, String name, String surname, LocalDate dateOfBirth, Integer numberOfBookWrited, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.numberOfBookWrited = numberOfBookWrited;
        this.books = books;
    }

    public Integer getNumberOfBookWrited() {
        return numberOfBookWrited;
    }

    public void setNumberOfBookWrited(Integer numberOfBookWrited) {
        this.numberOfBookWrited = numberOfBookWrited;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
