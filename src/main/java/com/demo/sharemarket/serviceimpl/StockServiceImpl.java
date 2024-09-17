package com.demo.sharemarket.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.sharemarket.modal.Stock;
import com.demo.sharemarket.modal.StockPrice;
import com.demo.sharemarket.repository.StockRepo;
import com.demo.sharemarket.service.StockService;


@Service
@Transactional
public class StockServiceImpl implements StockService{


    @Autowired
    private StockRepo stockRepo;

	public Stock find(int id) {
		return stockRepo.findById(id);
	}

	public Stock regStock(Stock stock) throws IOException  {
		return stockRepo.regStock(stock);
	}


	public Stock updateStock(Stock stock)   {
		return stockRepo.updateStocks(stock);
	}

	public boolean deleteStock(int id) {
		return stockRepo.deleteStocks(id);
	}

	@Override
	public List<Stock> getIDList() {
		return stockRepo.getIDList();
	}

	@Override
	public void updateStock(int stockId) {
		// TODO Auto-generated method stub
		
	}

	 @Override
	    public List<Stock> getAllStocksDetails() {
	        return stockRepo.findAll(); 
	    }
	@Override
	public List<StockPrice> getStockPrices(int stockId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock getStockById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	   @Override
	    public boolean stockExists(String companyname) {
	        return stockRepo.existsByCompanyname(companyname);
	    }
	
}
