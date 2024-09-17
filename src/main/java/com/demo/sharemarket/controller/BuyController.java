package com.demo.sharemarket.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.sharemarket.modal.Buy;
import com.demo.sharemarket.service.BuyService;

@RestController
@CrossOrigin("*")
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    BuyService buyservice;

    @PostMapping("/insert")
    public Buy insertBuy(@RequestBody Buy newBuy) {
        return buyservice.newBuy(newBuy);
    }

    @PutMapping("/updatebuy")
    public Buy updateBuy(@RequestBody Buy buy) {
        return buyservice.updateBuy(buy);
    }

    @GetMapping("/getallBuyList")
    public List<Buy> getBuys() {
        return buyservice.getBuys();
    }

    @GetMapping("/getbuyid/{buyId}")
    public Buy appfind(@PathVariable("buyId") int buyId) {
        return buyservice.buyfind(buyId);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public List<Buy> getBuysByPortfolioId(@PathVariable("portfolioId") int portfolioId) {
        return buyservice.findByPortfolioId(portfolioId);
    }

    @GetMapping("/user/{userId}")
    public List<Buy> getBuysByUserId(@PathVariable("userId") int userId) {
        return buyservice.findByUserId(userId);
    }
}
