package co.develhope.librarymanagement.service.inventory;

import co.develhope.librarymanagement.entities.inventory.Store;
import co.develhope.librarymanagement.entities.inventory.Warehouse;
import co.develhope.librarymanagement.repository.inventory.StoreRepository;
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

    public Store create(Store store, Long id) throws Exception {
        try{
            Optional<Warehouse> warehouse = warehouseService.getSingle(id);
            if(warehouse.isPresent()){
                store.setWarehouse(warehouse.get());
                storeRepository.save(store);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Incorrect input");
        }
        return store;
    }

    public Store update(Long id, Store store) throws Exception {
        if(!storeRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        store.setId(id);
        return storeRepository.save(store);
    }

    public List<Store> getAllStore() throws Exception {
        List<Store> stores = storeRepository.findAll();
        if(stores.isEmpty()){
            throw new Exception("Not stores found");
        }
        return stores;
    }

    public Optional<Store> findStoreById(Long storeId) throws Exception {
        try{
             return storeRepository.findById(storeId);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Store id not found");
        }
    }

    public String deleteAll() throws Exception {
        try{
            storeRepository.deleteAll();
            return "All stores are deleted";
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Can't delete all stores from db");
        }
    }

    public String deleteSingle(Long id) throws Exception {
        try {
            storeRepository.deleteById(id);
            return String.format("Store with id %d as delete", id);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Id not found");
        }
    }





}
