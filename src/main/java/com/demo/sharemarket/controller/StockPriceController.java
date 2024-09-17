package com.demo.sharemarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sharemarket.modal.StockPrice;
import com.demo.sharemarket.service.StockPriceService;



@RestController
@CrossOrigin("*")
@RequestMapping("/stockprices")
public class StockPriceController {
    @Autowired
    private StockPriceService stockPriceService;

    @PutMapping("/doStockPriceDetailsUpdate")
    public StockPrice updateStockPrice(@RequestBody StockPrice stockPrice) {
        StockPrice existingStockPrice = stockPriceService.getStockPriceByDate(stockPrice.getStock().getStockId(), stockPrice.getUpdatedDate());
        if (existingStockPrice != null) {
            existingStockPrice.setChangePrice(stockPrice.getChangePrice());
            return stockPriceService.updateStockPrice(existingStockPrice);
        } else {
            return stockPriceService.saveStockPrice(stockPrice);
        }
    }
    
    @GetMapping("/stock/{stockId}")
    public List<StockPrice> getStockPrices(@PathVariable int stockId) {
        return stockPriceService.getStockPrices( stockId);
    }
    @GetMapping("/latest/{stockId}")
    public StockPrice getLatestStockPrices(@PathVariable int stockId) {
        return stockPriceService.getLatestStockPrices(stockId);
    }

    @PostMapping("/create")
    public void createStockPrice(@RequestBody StockPrice stockPrice) {
        stockPriceService.saveStockPrice(stockPrice);
    }
}