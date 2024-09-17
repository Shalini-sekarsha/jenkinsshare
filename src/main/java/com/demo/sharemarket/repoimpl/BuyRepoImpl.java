package com.demo.sharemarket.repoimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.sharemarket.modal.Buy;
import com.demo.sharemarket.repository.BuyRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class BuyRepoImpl implements BuyRepo {

    @Autowired
    EntityManager entityMan;

    public Buy newBuy(Buy newBuy) {
        entityMan.persist(newBuy);
        return newBuy;
    }

    @SuppressWarnings("unchecked")
    public List<Buy> getBuys() {
        return entityMan.createQuery("from Buy").getResultList();
    }

    public Buy buyfind(int buyId) {
        return entityMan.find(Buy.class, buyId);
    }

    public Buy updateBuy(Buy buy) {
        entityMan.merge(buy);
        return buy;
    }

    public List<Integer> getBuyIdList() {
        Query q = entityMan.createQuery("SELECT c.buyId FROM Buy");
        return q.getResultList();
    }
    

    @SuppressWarnings("unchecked")
    public List<Buy> findByPortfolioId(int portfolioId) {
        String jpql = "SELECT b FROM Buy b WHERE b.portfolio.portfolioId = :portfolioId";
        Query query = entityMan.createQuery(jpql);
        query.setParameter("portfolioId", portfolioId);
        return query.getResultList();
    }
    @SuppressWarnings("unchecked")
    public List<Buy> findByUserId(int userId) {
        String jpql = "SELECT b FROM Buy b WHERE b.user.id = :userId";
        Query query = entityMan.createQuery(jpql);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
