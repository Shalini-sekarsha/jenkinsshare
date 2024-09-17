package com.demo.sharemarket.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.sharemarket.modal.Portfolio;
import com.demo.sharemarket.repository.PortfolioRepo;
import com.demo.sharemarket.service.PortfolioService;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepo portfolioRepo;

    @Override
    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepo.save(portfolio);
    }

    @Override
    public Optional<Portfolio> findPortfolioById(int id) {
        return portfolioRepo.findById(id);
    }

    @Override
    public List<Portfolio> findAllPortfolios() {
        return portfolioRepo.findAll();
    }

    @Override
    public Portfolio updatePortfolio(int id, Portfolio portfolio) {
        if (portfolioRepo.existsById(id)) {
            portfolio.setPortfolioId(id);
            return portfolioRepo.save(portfolio);
        } else {
            throw new RuntimeException("Portfolio not found");
        }
    }

    @Override
    public void deletePortfolio(int id) {
        portfolioRepo.deletePortfolio(id);
    }

    @Override
    public List<Portfolio> findPortfoliosByUserId(int userId) {
        return portfolioRepo.findByUserId(userId);
    }
}

