package co.develhope.librarymanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Invoice {

    @Id
    private int id;

    private LocalDate emissionDate;
    private Customer customer;
    private User user;
    private Book book;
}
