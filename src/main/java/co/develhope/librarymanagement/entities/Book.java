package co.develhope.librarymanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;
    private String plot;
    private int pages;
    private double price;
    @Column(unique = true)
    private String ISBN;
    private int numberOfEdition;
    private LocalDate publicationDate;
    private String bookGenre;
    private boolean availability;

    @OneToMany(mappedBy = "book")
    private Set<Stocktaking> stocktakings;


    public Book() {
    }

    public Book(int id, String title, Author author, String plot, int pages, double price, String ISBN, int numberOfEdition, LocalDate publicationDate, String bookGenre, boolean availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.plot = plot;
        this.pages = pages;
        this.price = price;
        this.ISBN = ISBN;
        this.numberOfEdition = numberOfEdition;
        this.publicationDate = publicationDate;
        this.bookGenre = bookGenre;
        this.availability = availability;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumberOfEdition() {
        return numberOfEdition;
    }

    public void setNumberOfEdition(int numberOfEdition) {
        this.numberOfEdition = numberOfEdition;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
}
