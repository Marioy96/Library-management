package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.entities.inventory.Invoice;
import co.develhope.librarymanagement.entities.inventory.Store;
import co.develhope.librarymanagement.service.inventory.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    private static Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @PostMapping("/create")
    public ResponseEntity createInvoice(@RequestBody Invoice invoice, @RequestParam Integer bookId,
                                        @RequestParam Integer userId,@RequestParam Integer customerId){
        try {
            logger.info("Create Invoice");
            return ResponseEntity.status(HttpStatus.OK).body(invoiceService.create(invoice,customerId,bookId,userId));

        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllInvoice(){
        try {
            logger.info("Get all Invoice");
            return ResponseEntity.status(HttpStatus.OK).body(invoiceService.getAllInvoice());
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getSingle/{id}")
    public ResponseEntity getInvoiceByID(@PathVariable Integer id){
        try {
            logger.info("Get invoice by Id");
            return ResponseEntity.status(HttpStatus.OK).body(invoiceService.getSingle(id));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateInvoice(@RequestBody Invoice invoice, @PathVariable Integer id){
        try{
            logger.info("Update Invoice");
            return ResponseEntity.status(HttpStatus.OK).body(invoiceService.update(id,invoice));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity deleteAllInvoice(){
        try {
            logger.info("Deleting all invoices");
            return ResponseEntity.status(HttpStatus.OK).body(invoiceService.deleteAll());
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteBYId/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        try {
            logger.info("Deleting invoice by Id");
            return ResponseEntity.status(HttpStatus.OK).body(invoiceService.deleteSingle(id));
        }catch (Exception e){
            logger.error(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
