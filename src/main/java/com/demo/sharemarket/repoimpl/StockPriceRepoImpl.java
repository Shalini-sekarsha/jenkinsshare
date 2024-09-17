package com.demo.sharemarket.repoimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.sharemarket.modal.StockPrice;
import com.demo.sharemarket.repository.StockPriceRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class StockPriceRepoImpl implements StockPriceRepo {

    @Autowired
    private EntityManager entityMan;

    @Override
    public List<StockPrice> getStockPrices(int stockId) {
        String jpql = "SELECT sp FROM StockPrice sp WHERE sp.stock.stockId = :stockId";
        TypedQuery<StockPrice> query = entityMan.createQuery(jpql, StockPrice.class);
        query.setParameter("stockId", stockId);
        return query.getResultList();
    }

//    @Override
//    public StockPrice saveStockPrice(StockPrice stockPrice) {
//        entityMan.persist(stockPrice);
//        return stockPrice;
//    }
    @Override
    public StockPrice saveStockPrice(StockPrice stockPrice) {
        
        if (stockPrice.getStockPriceId() == 0) {
            entityMan.persist(stockPrice);
        } else {
            entityMan.merge(stockPrice);
        }
        return stockPrice;
    }
    @Override
    public StockPrice updateStockPrice(StockPrice stockPrice) {
        return entityMan.merge(stockPrice);
    }

//    @Override
//    public List<StockPrice> findLatestStockPrices() {
//        String jpql = "SELECT sp FROM StockPrice sp " +
//                       "WHERE sp.updatedDate = (SELECT MAX(sp2.updatedDate) " +
//                                                "FROM StockPrice sp2 " +
//                                                "WHERE sp2.stock = sp.stock)";
//        TypedQuery<StockPrice> query = entityMan.createQuery(jpql, StockPrice.class);
//        return query.getResultList();
//    }
//    public List<StockPrice> findLatestStockPrices(int StockId) {
//        String jpql = "SELECT sp.stock.id, sp.changePrice " +
//                      "FROM StockPrice sp " +
//                      "WHERE sp.updatedDate = (SELECT MAX(sp2.updatedDate) " +
//                                              "FROM StockPrice sp2 " +
//                                              "WHERE sp2.stock.id = sp.stock.id)";
//
//        Query query = entityMan.createQuery(jpql);
//        return query.getResultList();
//    }

	

    public StockPrice findLatestStockPrices(int stockId) {
        String jpql = "SELECT sp " +
                      "FROM StockPrice sp " +
                      "WHERE sp.stock.id = :stockId " +
                      "ORDER BY sp.updatedDate DESC";

        Query query = entityMan.createQuery(jpql);
        query.setParameter("stockId", stockId);
        query.setMaxResults(1); 

        return (StockPrice) query.getSingleResult();
    }
    @Override
    public StockPrice findStockPriceByDate(int stockId, LocalDate updatedDate) {
        String jpql = "SELECT sp FROM StockPrice sp WHERE sp.stock.stockId = :stockId AND sp.updatedDate = :updatedDate";
        TypedQuery<StockPrice> query = entityMan.createQuery(jpql, StockPrice.class);
        query.setParameter("stockId", stockId);
        query.setParameter("updatedDate", updatedDate);
        List<StockPrice> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
 
	
}
