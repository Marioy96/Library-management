package co.develhope.librarymanagement.entities.inventory;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String address;
    private String telephoneNumber;
    private LocalDate dateOfBirth;
    private LocalDate dateOfHiring;


    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String employeeCode;

   /* @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_of_work_ID")
    private PlaceOfWork placeOfWork;

    public PlaceOfWork getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(PlaceOfWork placeOfWork) {
        this.placeOfWork = placeOfWork;
    }*/

    public Employee() {
    }

    public Employee(Long id, String name, String surname, String address, String telephoneNumber, LocalDate dateOfBirth, LocalDate dateOfHiring, String employeeCode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.dateOfHiring = dateOfHiring;
        this.employeeCode = employeeCode;
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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }





}
