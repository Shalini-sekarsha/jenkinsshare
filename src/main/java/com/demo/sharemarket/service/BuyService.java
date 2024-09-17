package com.demo.sharemarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.sharemarket.modal.Buy;

@Service
public interface BuyService {
    
    Buy newBuy(Buy newBuy);
    List<Buy> getBuys();
    Buy buyfind(int buyId);
    List<Integer> getBuyIdList();
    Buy updateBuy(Buy buy);
    List<Buy> findByUserId(int userId);
   
    List<Buy> findByPortfolioId(int portfolioId);
}
