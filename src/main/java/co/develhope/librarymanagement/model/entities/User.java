package co.develhope.librarymanagement.model.entities;


import co.develhope.librarymanagement.library.entities.Book;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String city;
    @Column(unique = true)
    private String fiscalCode;
    @Column(unique = true)
    private String telephoneNumber;
    @Column(unique = true)
    private String email;

    private String activationCode;
    private LocalDateTime jwtCreatedOn;
    private boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    public User(){}

    public User(Long id, String username, String password, String name, String surname, String dateOfBirth, String city, String fiscalCode, String telephoneNumber, String email, String activationCode, LocalDateTime jwtCreatedOn, boolean isActive, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.fiscalCode = fiscalCode;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.activationCode = activationCode;
        this.jwtCreatedOn = jwtCreatedOn;
        this.isActive = isActive;
        this.roles = roles;
    }

    public String getActivationCode() {
        return activationCode;
    }
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
    public LocalDateTime getJwtCreatedOn() {
        return jwtCreatedOn;
    }
    public void setJwtCreatedOn(LocalDateTime jwtCreatedOn) {
        this.jwtCreatedOn = jwtCreatedOn;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getFiscalCode() {
        return fiscalCode;
    }
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
