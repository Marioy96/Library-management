package co.develhope.librarymanagement.entities;

// TODO Entity and Table annotations
// TODO Id, constructors, getters and setters



import javax.persistence.*;


// Entity e Table sono annotazioni che informano Spring Data JPA che questa classe corrisponde ad una tabella
// nel database
@Entity
@Table(name = "Users")
public class User {


    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // Costruttore vuoto: obbligatorio per Spring Data JPA
    public User() {
    }

    public User(String username, String password, String name, String surname, String email, int id) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.id = id;
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
