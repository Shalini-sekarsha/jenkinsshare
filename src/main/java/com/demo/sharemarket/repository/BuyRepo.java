package com.demo.sharemarket.repository;

import java.util.List;
import com.demo.sharemarket.modal.Buy;

public interface BuyRepo {
    // Existing methods
    Buy newBuy(Buy newBuy);
    List<Buy> getBuys();
    Buy buyfind(int buyId);
    List<Integer> getBuyIdList();
    Buy updateBuy(Buy buy);
    List<Buy> findByUserId(int userId);
    
    // New method
    List<Buy> findByPortfolioId(int portfolioId);
}
