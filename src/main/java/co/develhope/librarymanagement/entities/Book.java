package co.develhope.librarymanagement.entities;


// TODO Potremmo avere tanti tipi di pubblicazione: libri, riviste, carte geografiche, spartiti musicali
// Sarebbe opportuno creare una superclasse "Product" con le opportune sottoclassi "Book", "Newspaper", ecc


public class Book {

    private String title;
    private String author;
    private String plot;
    private int pages;
    private float price;
    private String ISBN;

}
