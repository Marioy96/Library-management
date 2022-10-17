package co.develhope.librarymanagement.inventory.services;

import co.develhope.librarymanagement.inventory.entities.Employee;
import co.develhope.librarymanagement.inventory.entities.Store;
import co.develhope.librarymanagement.inventory.entities.Warehouse;
import co.develhope.librarymanagement.inventory.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StoreService storeService;

    @Autowired
    private WarehouseService warehouseService;

    public Employee create(Employee employee) throws Exception {
        try {
            if (employee == null) return null;
            return employeeRepository.save(employee);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Incorrect Input");
        }
    }

    public Employee update(Employee employee, Long id) throws Exception {
        if(!employeeRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        if(employee == null) throw new Exception("Employee body is null");
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee setPlaceOfWork(String employeeCode, Long placeOfWorkId) throws Exception {
        try {
            Optional<Employee> employee = employeeRepository.findByEmployeeCode(employeeCode);
            Optional<Warehouse> warehouse = warehouseService.getSingle(placeOfWorkId);
            Optional<Store> store = storeService.findStoreById(placeOfWorkId);
            if(employee.isPresent() && warehouse.isPresent()){
                employee.get().setWarehouse(warehouse.get());
                employeeRepository.save(employee.get());
            } else if (employee.isPresent() && store.isPresent()) {
                employee.get().setStore(store.get());
                employeeRepository.save(employee.get());
            }else throw new Exception("Not place of work found");

            return employee.get();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> getAll() throws Exception {
        List<Employee> employees = employeeRepository.findAll();
        if(employees.isEmpty()) throw new Exception("Employees not found");
        return employees;
    }

    public Optional<Employee> getEmployeeByCode(String code) throws Exception {
        try {
            return employeeRepository.findByEmployeeCode(code);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Id not found");
        }

    }

    public Optional<Employee> getEmployeeById(Long id) throws Exception {
        try {
            return employeeRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Id not found");
        }

    }

    public String deleteByCode(String code) throws Exception {
        try {
            employeeRepository.deleteByEmployeeCode(code);
            return String.format("Author whit id %s as deleted ", code);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Employee code not found");
        }
    }

    public String deleteEmployeeById(Long id) throws Exception {
        try {
            employeeRepository.deleteById(id);
            return String.format("Employee whit id %d as deleted ", id);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Employee id not found");
        }

    }

    public String deleteAllEmployee() throws Exception {
        try {
            employeeRepository.deleteAll();
            return "All employee al deleted";
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Can't delete all employee from db");
        }
    }





}
