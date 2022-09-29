package co.develhope.librarymanagement.entities;


import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    private String username;
    private String password;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;

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

    public void setId(Integer id) {
        this.id = id;
    }
}
