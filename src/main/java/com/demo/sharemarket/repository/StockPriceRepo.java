package com.demo.sharemarket.repository;

import java.time.LocalDate;
import java.util.List;

import com.demo.sharemarket.modal.StockPrice;

public interface StockPriceRepo {
	public List<StockPrice> getStockPrices(int stockId) ;
	public StockPrice saveStockPrice(StockPrice stockPrice);
	public StockPrice updateStockPrice(StockPrice stockPrice);
	public StockPrice findLatestStockPrices(int stockId);
	 StockPrice findStockPriceByDate(int stockId, LocalDate updatedDate);
}
