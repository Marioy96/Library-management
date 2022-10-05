package co.develhope.librarymanagement.service.inventory;

import co.develhope.librarymanagement.entities.inventory.Warehouse;
import co.develhope.librarymanagement.repository.inventory.StocktakingRepository;
import co.develhope.librarymanagement.repository.inventory.StoreRepository;
import co.develhope.librarymanagement.repository.inventory.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private StocktakingRepository stocktakingRepository;

    @Autowired
    private StoreRepository storeRepository;

    public Optional<Warehouse> getSingle(Integer id) throws Exception {
        try{
           return warehouseRepository.findById(id);
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }

    public List<Warehouse> getAll() throws Exception {
        List<Warehouse> allWarehouse =warehouseRepository.findAll();
        if(allWarehouse.isEmpty()){
            throw new Exception("Not warehouses found");
        }
        return allWarehouse;
    }

    public Warehouse create(Warehouse warehouse) throws Exception {
        try {
              return  warehouseRepository.save(warehouse);
        } catch (Exception e){
            throw new Exception("Incorrect input");
        }

    }

    public Warehouse update(Integer id, Warehouse warehouse) throws Exception {
        if(!warehouseRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        return warehouseRepository.save(warehouse);
    }

    public String deleteSingle(Integer id) throws Exception {
        try {
            warehouseRepository.deleteById(id);
            return String.format("Warehouse with id %d as delete", id);
        }catch (Exception e){
            throw new Exception("warehouse id not found");
        }
    }

    public String deleteAll() throws Exception {
        try{
            warehouseRepository.deleteAll();
            return "All warehouse are deleted";
        }catch (Exception e){
        throw new Exception("Can't delete all werehouse from db");
    }
    }








}
