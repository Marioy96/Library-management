package co.develhope.librarymanagement.inventory.entities;

import co.develhope.librarymanagement.model.entities.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String surname;
    private String address;
    @Column(unique = true)
    private String telephoneNumber;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String fiscalCode;
    private LocalDate dateOfBirth;
    private LocalDate dateOfHiring;
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String employeeCode;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    private String activationCode;
    private LocalDateTime jwtCreatedOn;
    private boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "EMPLOYEE_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    public Employee() {
    }

    public Employee(Long id, String name, String surname, String address, String telephoneNumber, String email,
                    String fiscalCode, LocalDate dateOfBirth, LocalDate dateOfHiring, String employeeCode,
                    Store store, Warehouse warehouse, String activationCode, LocalDateTime jwtCreatedOn,
                    boolean isActive, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.fiscalCode = fiscalCode;
        this.dateOfBirth = dateOfBirth;
        this.dateOfHiring = dateOfHiring;
        this.employeeCode = employeeCode;
        this.store = store;
        this.warehouse = warehouse;
        this.activationCode = activationCode;
        this.jwtCreatedOn = jwtCreatedOn;
        this.isActive = isActive;
        this.roles = roles;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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
    public String getFiscalCode() {
        return fiscalCode;
    }
    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public LocalDate getDateOfHiring() {
        return dateOfHiring;
    }
    public void setDateOfHiring(LocalDate dateOfHiring) {
        this.dateOfHiring = dateOfHiring;
    }
    public String getEmployeeCode() {
        return employeeCode;
    }
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
    public Warehouse getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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





}
