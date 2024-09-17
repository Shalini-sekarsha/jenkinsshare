package com.demo.sharemarket.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.sharemarket.modal.Buy;
import com.demo.sharemarket.repository.BuyRepo;
import com.demo.sharemarket.service.BuyService;

@Service
@Transactional
public class BuyServiceImpl implements BuyService {

    @Autowired
    BuyRepo buydao;

    public Buy newBuy(Buy newBuy) {
        return buydao.newBuy(newBuy);
    }

    public List<Buy> getBuys() {
        return buydao.getBuys();
    }

    public Buy buyfind(int buyId) {
        return buydao.buyfind(buyId);
    }

    public List<Integer> getBuyIdList() {
        return buydao.getBuyIdList();
    }

    public Buy updateBuy(Buy buy) {
        return buydao.updateBuy(buy);
    }
    
    public List<Buy> findByPortfolioId(int portfolioId) {
        return buydao.findByPortfolioId(portfolioId);
    }
    public List<Buy> findByUserId(int userId) {
        return buydao.findByUserId(userId);
    }
}
