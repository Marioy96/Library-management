package co.develhope.librarymanagement.controller.inventory;

import co.develhope.librarymanagement.entities.inventory.Stocktaking;
import co.develhope.librarymanagement.service.inventory.StocktakingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocktaking")
public class StocktakingController {

    @Autowired
    private StocktakingService stocktakingService;

    private static Logger logger = LoggerFactory.getLogger(StoreController.class);

    @PostMapping("/create")
    public ResponseEntity createStock(@RequestBody Stocktaking stocktaking,
                                      @RequestParam Long bookId,@RequestParam Long warehouseId){
        try {
            logger.info("Insert a stock");
            return ResponseEntity.status(HttpStatus.OK).body(stocktakingService.createStock(stocktaking,bookId,warehouseId));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity getAllStock() {
        try {
            logger.info("Get all Stock");
            return ResponseEntity.status(HttpStatus.OK).body(stocktakingService.findAllStocktaking());
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity getStockById(@PathVariable Long id){
        try {
            logger.info("Get Stock by Id");
            return ResponseEntity.status(HttpStatus.OK).body(stocktakingService.findStocktakingById(id));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStock(@PathVariable Long id, @RequestParam Stocktaking stocktaking) {
        try {
            logger.info("Update Stock");
            return ResponseEntity.status(HttpStatus.OK).body(stocktakingService.updateStocktaking(id, stocktaking));
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteStockById/{id}")
    public ResponseEntity deleteStockById(@PathVariable Long id) {
        try{
            logger.info("Delete a stock by id");
            return ResponseEntity.status(HttpStatus.OK).body(stocktakingService.deleteSingleStock(id));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("/deleteAllStock")
    public ResponseEntity deleteAllStock(){
        try{
            logger.info("Delete all stock ");
            return ResponseEntity.status(HttpStatus.OK).body(stocktakingService.deleteAllStocktaking());
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
