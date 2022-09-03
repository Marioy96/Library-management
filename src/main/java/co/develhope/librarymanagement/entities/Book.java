package co.develhope.librarymanagement.entities;


// TODO Potremmo avere tanti tipi di pubblicazione: libri, riviste, carte geografiche, spartiti musicali
// Sarebbe opportuno creare una superclasse "Product" con le opportune sottoclassi "Book", "Newspaper", ecc

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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

    public Book() {
    }

    public Book(int id, String title, Author author, String plot, int pages, double price, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.plot = plot;
        this.pages = pages;
        this.price = price;
        this.ISBN = ISBN;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
