package com.demo.sharemarket.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.sharemarket.modal.Stock;
import com.demo.sharemarket.repository.StockRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
@Repository
public class StockRepoImpl implements StockRepo{
	@Autowired
	EntityManager entityMan;

	public Stock findById(int id) {
		return entityMan.find(Stock.class, id);
	}
 
	public Stock regStock(Stock stock) {
		
		entityMan.persist(stock);
		return stock;
	}
	public List<Stock> findAll() {
		String hql="from Stock";
		Query query=entityMan.createQuery(hql);
		
		return query.getResultList();
	}
	public boolean deleteStocks(int id) {
		Query query = entityMan.createQuery("DELETE Stock p WHERE p.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		return true;
	}

	@Override
	public Stock updateStocks(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

	


	    @Override
	    public List<Stock> getIDList() {
	        CriteriaBuilder criteriaBuilder = entityMan.getCriteriaBuilder();
	        CriteriaQuery<Stock> criteriaQuery = criteriaBuilder.createQuery(Stock.class);
	        Root<Stock> stockRoot = criteriaQuery.from(Stock.class);
	        criteriaQuery.select(stockRoot);

	        return entityMan.createQuery(criteriaQuery).getResultList();
	    }
	    @Override
	    public boolean existsByCompanyname(String companyname) {
	        String hql = "SELECT COUNT(s) FROM Stock s WHERE s.companyname = :companyname";
	        Query query = entityMan.createQuery(hql);
	        query.setParameter("companyname", companyname);
	        long count = (long) query.getSingleResult();
	        return count > 0;
	    }
	}


	
 

