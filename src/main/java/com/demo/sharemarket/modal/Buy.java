package com.demo.sharemarket.modal;

import java.util.List;

import org.hibernate.mapping.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Buy")
public class Buy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	private int changePrice;
	private int totalPrice;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;
	@ManyToOne
	@JoinColumn(name = "portfolio_id")
	private Portfolio portfolio;

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public Buy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buy(int id, int quantity, int changePrice, int totalPrice, User user, Stock stock) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.changePrice = changePrice;
		this.totalPrice = totalPrice;
		this.user = user;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getChangePrice() {
		return changePrice;
	}

	public void setChangePrice(int changePrice) {
		this.changePrice = changePrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Buy [id=" + id + ", quantity=" + quantity + ", changePrice=" + changePrice + ", totalPrice="
				+ totalPrice + ", user=" + user + ", stock=" + stock + "]";
	}

}