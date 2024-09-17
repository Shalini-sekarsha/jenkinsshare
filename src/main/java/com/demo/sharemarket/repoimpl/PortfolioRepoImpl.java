package com.demo.sharemarket.repoimpl;

import com.demo.sharemarket.modal.Portfolio;
import com.demo.sharemarket.repository.PortfolioRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class PortfolioRepoImpl implements PortfolioRepo {

    @Autowired
    private EntityManager entityMan;

    @Override
    public Optional<Portfolio> findPortfolioById(int id) {
        Portfolio portfolio = entityMan.find(Portfolio.class, id);
        return Optional.ofNullable(portfolio);
    }

    @Override
    public List<Portfolio> findAllPortfolios() {
        TypedQuery<Portfolio> query = entityMan.createQuery("SELECT p FROM Portfolio p", Portfolio.class);
        return query.getResultList();
    }

    @Override
    public Portfolio updatePortfolio(int id, Portfolio portfolio) {
        if (entityMan.find(Portfolio.class, id) != null) {
            portfolio.setPortfolioId(id);
            return entityMan.merge(portfolio);
        } else {
            throw new RuntimeException("Portfolio not found");
        }
    }

    @Override
    public void deletePortfolio(int id) {
        Portfolio portfolio = entityMan.find(Portfolio.class, id);
        if (portfolio != null) {
            entityMan.remove(portfolio);
        } else {
            throw new RuntimeException("Portfolio not found");
        }
    }

    @Override
    public Optional<Portfolio> findById(int id) {
        Portfolio portfolio = entityMan.find(Portfolio.class, id);
        return Optional.ofNullable(portfolio);
    }

    @Override
    public List<Portfolio> findAll() {
        TypedQuery<Portfolio> query = entityMan.createQuery("SELECT p FROM Portfolio p", Portfolio.class);
        return query.getResultList();
    }

    @Override
    public boolean existsById(int id) {
        return entityMan.find(Portfolio.class, id) != null;
    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        entityMan.merge(portfolio);
        return portfolio;
    }

    @Override
    public Portfolio savePortfolio(Portfolio portfolio) {
        entityMan.merge(portfolio);
        return portfolio;
    }

    @Override
    public List<Portfolio> findByUserId(int userId) {
        TypedQuery<Portfolio> query = entityMan.createQuery("SELECT p FROM Portfolio p WHERE p.user.userId = :userId", Portfolio.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}

	

	

