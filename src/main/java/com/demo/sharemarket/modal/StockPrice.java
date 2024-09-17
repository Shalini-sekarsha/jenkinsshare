package com.demo.sharemarket.modal;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StockPrice {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int stockPriceId;

	    @ManyToOne
	    @JoinColumn(name = "stock_id")
	    private Stock stock;

	    private int changePrice;
	    private LocalDate updatedDate;
		public StockPrice(int stockPriceId, Stock stock, int changePrice, LocalDate updatedDate) {
			super();
			this.stockPriceId = stockPriceId;
			this.stock = stock;
			this.changePrice = changePrice;
			this.updatedDate = updatedDate;
		}
		public StockPrice() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getStockPriceId() {
			return stockPriceId;
		}
		public void setStockPriceId(int stockPriceId) {
			this.stockPriceId = stockPriceId;
		}
		public Stock getStock() {
			return stock;
		}
		public void setStock(Stock stock) {
			this.stock = stock;
		}
		public int getChangePrice() {
			return changePrice;
		}
		public void setChangePrice(int changePrice) {
			this.changePrice = changePrice;
		}
		public LocalDate getUpdatedDate() {
			return updatedDate;
		}
		public void setUpdatedDate(LocalDate updatedDate) {
			this.updatedDate = updatedDate;
		}
		@Override
		public String toString() {
			return "StockPrice [stockPriceId=" + stockPriceId + ", stock=" + stock + ", changePrice=" + changePrice
					+ ", updatedDate=" + updatedDate + "]";
		}

}
