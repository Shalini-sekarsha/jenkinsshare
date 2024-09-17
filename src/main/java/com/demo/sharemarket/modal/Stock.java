package com.demo.sharemarket.modal;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;
    @Column(unique = true)
    private String companyname;
    private String symbol;
    private String shareprice;
	public Stock(int stockId, String companyname, String symbol, String shareprice) {
		super();
		this.stockId = stockId;
		
		this.companyname = companyname;
		this.symbol = symbol;
		this.shareprice = shareprice;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getShareprice() {
		return shareprice;
	}
	public void setShareprice(String shareprice) {
		this.shareprice = shareprice;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", companyname=" + companyname + ", symbol=" + symbol + ", shareprice="
				+ shareprice + "]";
	}
	
}