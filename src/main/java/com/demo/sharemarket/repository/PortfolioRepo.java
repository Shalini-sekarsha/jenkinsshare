package com.demo.sharemarket.repository;

import java.util.List;
import java.util.Optional;

import com.demo.sharemarket.modal.Portfolio;
public interface PortfolioRepo {

    public Portfolio savePortfolio(Portfolio portfolio);

    public Optional<Portfolio> findPortfolioById(int id);

    public List<Portfolio> findAllPortfolios();

    public Portfolio updatePortfolio(int id, Portfolio portfolio);

    public void deletePortfolio(int id);

    public Optional<Portfolio> findById(int id);

    public List<Portfolio> findAll();

    public boolean existsById(int id);

    public Portfolio save(Portfolio portfolio);

    public List<Portfolio> findByUserId(int userId);
}


