package com.demo.sharemarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.sharemarket.modal.Portfolio;


import java.util.List;
import java.util.Optional;

//@Service
//public interface PortfolioService {
//    public Portfolio savePortfolio(Portfolio portfolio); 
//  
//    public Optional<Portfolio> findPortfolioById(int id); 
//
//    public List<Portfolio> findAllPortfolios(); 
//    public Portfolio updatePortfolio(int id, Portfolio portfolio); 
//
//    public void deletePortfolio(int id); 
//}
@Service
public interface PortfolioService {

    public Portfolio savePortfolio(Portfolio portfolio);

    public Optional<Portfolio> findPortfolioById(int id);

    public List<Portfolio> findAllPortfolios();

    public Portfolio updatePortfolio(int id, Portfolio portfolio);

    public void deletePortfolio(int id);

    // New method signature
    public List<Portfolio> findPortfoliosByUserId(int userId);
}

