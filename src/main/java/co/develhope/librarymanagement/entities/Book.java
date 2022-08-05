package co.develhope.librarymanagement.entities;


// TODO Potremmo avere tanti tipi di pubblicazione: libri, riviste, carte geografiche, spartiti musicali
// Sarebbe opportuno creare una superclasse "Product" con le opportune sottoclassi "Book", "Newspaper", ecc

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String author;
    private String plot;
    private int pages;
    private float price;
    private String ISBN;

    public Book() {
    }

    public Book(int id, String title, String author, String plot, int pages, float price, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.plot = plot;
        this.pages = pages;
        this.price = price;
        this.ISBN = ISBN;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
