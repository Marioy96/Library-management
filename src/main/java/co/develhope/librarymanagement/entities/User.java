package co.develhope.librarymanagement.entities;

// TODO Entity and Table annotations
// TODO Id, constructors, getters and setters



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// Entity e Table sono annotazioni che informano Spring Data JPA che questa classe corrisponde ad una tabella
// nel database
@Entity
@Table(name = "Users")
public class User {

    // Id è un'annotazione che informa Spring Data JPA che id è chiave primaria di questa entità
    // GeneratedValue chiede a Spring Data JPA di generare automaticamente un id crescente ogni volta che viene
    // inserito un nuovo utente nel DB
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    private String name;
    private String surname;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true)
    private String telephoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    List<Book> bookAcquired = new ArrayList<>();


    // Costruttore vuoto: obbligatorio per Spring Data JPA
    public User() {
    }

    public User(String username, String password, String name, String surname, String email, String telephoneNumber, int id) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.id = id;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
