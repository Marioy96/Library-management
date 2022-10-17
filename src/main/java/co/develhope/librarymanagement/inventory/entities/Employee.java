package co.develhope.librarymanagement.inventory.entities;

import javax.persistence.*;
import java.time.LocalDate;



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

    public Employee() {
    }

    public Employee(Long id, String name, String surname, String address, String telephoneNumber,
                    String email, String fiscalCode, LocalDate dateOfBirth, LocalDate dateOfHiring,
                    String employeeCode, Store store, Warehouse warehouse) {
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





}
