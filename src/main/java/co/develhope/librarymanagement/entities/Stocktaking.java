package co.develhope.librarymanagement.entities;

import javax.persistence.*;


@Entity
@Table(name = "stocktaking")
public class Stocktaking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinColumn(name = "book_id")
    private Book fkBook;

}
