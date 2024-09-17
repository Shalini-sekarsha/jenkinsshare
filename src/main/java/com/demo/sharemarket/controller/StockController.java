
package com.demo.sharemarket.controller;

import com.demo.sharemarket.modal.Stock;
import com.demo.sharemarket.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/createStock")
    public ResponseEntity<?> regStock(@RequestBody Stock stock) {
        try {
           
            if (stockService.stockExists(stock.getCompanyname())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Stock with this company name already exists.");
            }

            Stock createdStock = stockService.regStock(stock);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding stock.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getStock() {
        List<Stock> stocks = stockService.getAllStocksDetails();
        return ResponseEntity.ok(stocks);
    }
    

    @GetMapping("/idlist")
    public ResponseEntity<List<Stock>> getIDList() {
        List<Stock> stocks = stockService.getIDList();
        return ResponseEntity.ok(stocks);
    }

    @GetMapping("/GetStockId/{id}")
    public ResponseEntity<Stock> find(@PathVariable("id") int id) {
        Stock stock = stockService.find(id);
        if (stock != null) {
            return ResponseEntity.ok(stock);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Stock> getStockDetails(@PathVariable("id") int id) {
        Stock stock = stockService.find(id);
        if (stock != null) {
            return ResponseEntity.ok(stock);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/doStockDetailsUpdate")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
        Stock updatedStock = stockService.updateStock(stock);
        if (updatedStock != null) {
            return ResponseEntity.ok(updatedStock);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/deleteStock/{id}")
    public ResponseEntity<?> deleteStocks(@PathVariable("id") int id) {
        boolean deleted = stockService.deleteStock(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock not found.");
        }
    }
}
