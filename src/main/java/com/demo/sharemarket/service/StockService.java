package com.demo.sharemarket.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.sharemarket.modal.Stock;
import com.demo.sharemarket.modal.StockPrice;
import com.demo.sharemarket.repository.StockRepo;

import java.io.IOException;
import java.util.List;

@Service
public interface StockService {
	
 
    List<Stock> getAllStocksDetails();
    
	public Stock find(int id);

	
	 
	public List<Stock> getIDList();
	public Stock updateStock(Stock stock);

	public boolean deleteStock(int id);

	public Stock regStock(Stock stock) throws IOException;
	
	    boolean stockExists(String companyName); 

	void updateStock(int stockId);

	List<StockPrice> getStockPrices(int stockId);
	
	public Stock getStockById(int id);

}

