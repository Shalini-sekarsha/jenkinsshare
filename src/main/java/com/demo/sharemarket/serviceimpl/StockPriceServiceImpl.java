package com.demo.sharemarket.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.sharemarket.modal.StockPrice;
import com.demo.sharemarket.repository.StockPriceRepo;
import com.demo.sharemarket.service.StockPriceService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class StockPriceServiceImpl implements StockPriceService {
	

    @Autowired
    private StockPriceRepo stockPriceRepo;
	
	public List<StockPrice> getStockPrices(int stockId) {
		return stockPriceRepo.getStockPrices( stockId);
	}

	@Override
	public StockPrice saveStockPrice(StockPrice stockPrice) {
		return stockPriceRepo.saveStockPrice(stockPrice);
	}
	 @Override
	    public StockPrice getStockPriceByDate(int stockId, LocalDate updatedDate) {
	        return stockPriceRepo.findStockPriceByDate(stockId, updatedDate);
	    }

	@Override
	public StockPrice updateStockPrice(StockPrice stockPrice) {
		
		return stockPriceRepo.updateStockPrice(stockPrice);
	}
	@Override
	public StockPrice getLatestStockPrices(int stockId) {
        return stockPriceRepo.findLatestStockPrices(stockId);
    }

}

