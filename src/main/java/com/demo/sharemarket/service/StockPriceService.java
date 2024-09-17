package com.demo.sharemarket.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.sharemarket.modal.StockPrice;

@Service
public interface StockPriceService {
	
	public List<StockPrice> getStockPrices(int stockId) ;
	public StockPrice saveStockPrice(StockPrice stockPrice);
	public StockPrice updateStockPrice(StockPrice stockPrice);
	public StockPrice getLatestStockPrices(int stockId);
	 StockPrice getStockPriceByDate(int stockId, LocalDate updatedDate);
    }
	

