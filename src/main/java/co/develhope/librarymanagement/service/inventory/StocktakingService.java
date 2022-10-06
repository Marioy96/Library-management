package co.develhope.librarymanagement.service.inventory;

import co.develhope.librarymanagement.entities.library.Book;
import co.develhope.librarymanagement.entities.inventory.Stocktaking;
import co.develhope.librarymanagement.entities.inventory.Warehouse;
import co.develhope.librarymanagement.repository.inventory.StocktakingRepository;
import co.develhope.librarymanagement.service.library.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StocktakingService {

    @Autowired
    private StocktakingRepository stocktakingRepository;
    @Autowired
    private BookService bookService;
    @Autowired
    private WarehouseService warehouseService;

    public Stocktaking createStock(Stocktaking stocktaking,Integer bookId,Integer warehouseId) throws Exception {
        try {
            Optional<Book> book = bookService.findBookById(bookId);
            Optional<Warehouse> warehouse = warehouseService.getSingle(warehouseId);
            if(book.isPresent()&& warehouse.isPresent()){
                stocktaking.setBook(book.get());
                stocktaking.setWarehouse(warehouse.get());
                stocktakingRepository.save(stocktaking);
            }
            return stocktaking;
        }catch (Exception e){
            throw new Exception("Incorrect input");
        }
    }

    public List<Stocktaking> findAllStocktaking() throws Exception {
        List<Stocktaking> allStock = stocktakingRepository.findAll();
        if(allStock.isEmpty()){
            throw new Exception("Not stocktaking found");
        }
        return allStock;
    }

    public Optional<Stocktaking> findStocktakingById(Integer id) throws Exception {
        try{
            return stocktakingRepository.findById(id);
        }catch (Exception e){
        throw new Exception("Id not found");
    }
    }

    public Stocktaking updateStocktaking(Integer id,Stocktaking stocktaking) throws Exception {
        if(!stocktakingRepository.existsById(id)){
            throw new Exception("Id doesn't exist");
        }
        stocktaking.setId(id);
        return stocktakingRepository.save(stocktaking);
    }

    public String deleteAllStocktaking() throws Exception {
        try{
            stocktakingRepository.deleteAll();
            return "All stocktaking are deleted";
        }catch (Exception e){
            throw new Exception("Can't delete all stock from db");
        }

    }

    public String deleteSingleStock(Integer id) throws Exception {
        try {
            stocktakingRepository.deleteById(id);
            return String.format("Stocktaking with id %d as delete", id);
        }catch (Exception e){
            throw new Exception("Stocktaking id not found");
        }
    }


}
