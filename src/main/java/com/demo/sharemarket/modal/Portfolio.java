//package com.demo.sharemarket.modal;
////
////import java.math.BigDecimal;
////
////import org.hibernate.mapping.Set;
////
////import jakarta.persistence.Entity;
////
////import jakarta.persistence.GeneratedValue;
////import jakarta.persistence.GenerationType;
////import jakarta.persistence.Id;
////import jakarta.persistence.JoinColumn;
////import jakarta.persistence.JoinTable;
////import jakarta.persistence.ManyToMany;
////import jakarta.persistence.OneToOne;
////import jakarta.persistence.Table;
////
////@Entity
////@Table(name = "Portfolio")
////public class Portfolio {
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long portfolioId;
////
////    public Portfolio() {
////		super();
////		// TODO Auto-generated constructor stub
////	}
////	
////	public Set getStock() {
////		return stock;
////	}
////
////	public void setStock(Set stock) {
////		this.stock = stock;
////	}
////
////	public Long getPortfolioId() {
////		return portfolioId;
////	}
////	public void setPortfolioId(Long portfolioId) {
////		this.portfolioId = portfolioId;
////	}
////	
////	public String getCompanyname() {
////		return companyname;
////	}
////	public void setCompanyname(String companyname) {
////		this.companyname = companyname;
////	}
////	public String getChangePrice() {
////		return changePrice;
////	}
////	public void setChangePrice(String changePrice) {
////		this.changePrice = changePrice;
////	}
////	public int getQuantity() {
////		return quantity;
////	}
////	public void setQuantity(int quantity) {
////		this.quantity = quantity;
////	}
////	public BigDecimal getTotalPrice() {
////		return totalPrice;
////	}
////	public void setTotalPrice(BigDecimal totalPrice) {
////		this.totalPrice = totalPrice;
////	}
//////	@OneToOne
//////    @JoinColumn(name = "user_id", unique = true)
////	 @ManyToMany
////	    @JoinTable(
////	        name = "stock",
////	        joinColumns = @JoinColumn(name = "portfolio_id"),
////	        inverseJoinColumns = @JoinColumn(name = "stock_id")
////	    )
////	    private Set stock;
////   
////    private String companyname;
////    private String changePrice;
////    private int quantity;
////    private BigDecimal totalPrice;
//package com.demo.sharemarket.modal;
//
//import java.math.BigDecimal;
//import java.util.Set;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "portfolio")
//public class Portfolio {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long portfolioId;
//
//    @ManyToMany
//    @JoinTable(
//        name = "portfolio_stock", // The join table for many-to-many relationship
//        joinColumns = @JoinColumn(name = "portfolio_id"),
//        inverseJoinColumns = @JoinColumn(name = "stock_id")
//    )
//    private Set<Stock> stocks;
//
//    private String companyname; // Camel case for field names
//    private String changePrice;
//    private int quantity;
//    private BigDecimal totalPrice;
//
//    // Getters and setters
//    public Long getPortfolioId() {
//        return portfolioId;
//    }
//
//    public void setPortfolioId(Long portfolioId) {
//        this.portfolioId = portfolioId;
//    }
//
//    public Set<Stock> getStocks() {
//        return stocks;
//    }
//
//    public void setStocks(Set<Stock> stocks) {
//        this.stocks = stocks;
//    }
//
//    public String getCompanyname() {
//        return companyname;
//    }
//
//    public void setCompanyname(String companyname) {
//        this.companyname = companyname;
//    }
//
//    public String getChangePrice() {
//        return changePrice;
//    }
//
//    public void setChangePrice(String changePrice) {
//        this.changePrice = changePrice;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public BigDecimal getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(BigDecimal totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//    @Override
//    public String toString() {
//        return "Portfolio [portfolioId=" + portfolioId + ", stocks=" + stocks + ", companyname=" + companyname
//                + ", changePrice=" + changePrice + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
//    }
//}
package com.demo.sharemarket.modal;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Portfolio")
public class Portfolio {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int portfolioId;
private String portfolioname; 

@ManyToOne
@JoinColumn(name = "user_id")  
private User user;
@OneToMany
private List<Stock> stocks;

public List<Stock> getStocks() {
	return stocks;
}
public void setStocks(List<Stock> stocks) {
	this.stocks = stocks;
}
public Portfolio() {
	super();
	
}
public Portfolio(int portfolioId, String portfolioname, User user) {
	super();
	this.portfolioId = portfolioId;
	this.portfolioname = portfolioname;
	this.user = user;
}
public int getPortfolioId() {
	return portfolioId;
}
public void setPortfolioId(int portfolioId) {
	this.portfolioId = portfolioId;
}
public String getPortfolioname() {
	return portfolioname;
}
public void setPortfolioname(String portfolioname) {
	this.portfolioname = portfolioname;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Override
public String toString() {
	return "Portfolio [portfolioId=" + portfolioId + ", portfolioname=" + portfolioname + ", user=" + user + "]";
}
}

