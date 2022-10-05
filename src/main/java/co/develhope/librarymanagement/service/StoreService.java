package co.develhope.librarymanagement.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import co.develhope.librarymanagement.entities.Store;
import co.develhope.librarymanagement.entities.Warehouse;
import co.develhope.librarymanagement.repository.StoreRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private WarehouseService warehouseService;

    public Store create(Store store, Integer id) throws Exception {
        try{
            Optional<Warehouse> warehouse = warehouseService.getSingle(id);
            if(warehouse.isPresent()){
                store.setWarehouse(warehouse.get());
                storeRepository.save(store);
            }
            return store;
        } catch (Exception e) {
            throw new Exception("Incorrect input");
        }
    }

    public Store update(Integer id, Store store) throws Exception {
        if(!storeRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        return storeRepository.save(store);
    }

    public List<Store> getAllStore() throws Exception {
        List<Store> stores = storeRepository.findAll();
        if(stores.isEmpty()){
            throw new Exception("Not stores found");
        }
        return stores;
    }

    public Optional<Store> findStoreById(Integer storeId) throws Exception {
        try{
             return storeRepository.findById(storeId);
        }catch (Exception e){
            throw new Exception("Book id not found");
        }
    }

    public String deleteAll() throws Exception {
        try{
            storeRepository.deleteAll();
            return "All stores are deleted";
        }catch (Exception e){
            throw new Exception("Can't delete all stores from db");
        }
    }

    public String deleteSingle(Integer id) throws Exception {
        try {
            storeRepository.deleteById(id);
            return String.format("Store with id %d as delete", id);
        }catch (Exception e){
            throw new Exception("Id not found");
        }
    }





}
