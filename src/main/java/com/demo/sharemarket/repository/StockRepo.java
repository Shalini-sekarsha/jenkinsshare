package com.demo.sharemarket.repository;

import java.util.List;


import com.demo.sharemarket.modal.Stock;



public interface StockRepo {
	
	

	 abstract List<Stock> findAll();
		public Stock findById(int id);
	 
		public Stock updateStocks(Stock stock);
	 
		public boolean deleteStocks(int id);

		public Stock regStock(Stock stock);
		 boolean existsByCompanyname(String companyname); 
		
		public List<Stock> getIDList();

		


	 

}
