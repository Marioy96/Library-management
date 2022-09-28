package co.develhope.librarymanagement.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private List<Stocktaking> stocktaking;
    private String city;
    private LocalDate orarioApertura;
    private LocalDate orarioChiusura;
    private List<Employee> employeeList;
}