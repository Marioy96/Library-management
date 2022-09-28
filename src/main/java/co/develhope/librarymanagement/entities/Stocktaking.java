package co.develhope.librarymanagement.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "stocktaking")
public class Stocktaking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "book_id")
    private List<Book> listOfBooks;

   private List<Employee> employee;
   private List<Customer> customer;
   private List<Invoice> invoice;

}
