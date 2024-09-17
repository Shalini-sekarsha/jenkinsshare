package com.demo.sharemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.sharemarket.modal.Portfolio;
import com.demo.sharemarket.service.PortfolioService;

import java.util.List;
import java.util.Optional;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/portfolio")
//public class PortfolioController {
//
//    @Autowired
//    private PortfolioService portfolioService;
//
//    @PostMapping("/create")
//    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
//    	System.out.println(portfolio);
//        Portfolio createdPortfolio = portfolioService.savePortfolio(portfolio);
//        return ResponseEntity.ok(createdPortfolio);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable int id) {
//        Optional<Portfolio> portfolio = portfolioService.findPortfolioById(id);
//        return portfolio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Portfolio>> getAllPortfolios() {
//        List<Portfolio> portfolios = portfolioService.findAllPortfolios();
//        return ResponseEntity.ok(portfolios);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable int id, @RequestBody Portfolio portfolio) {
//        Portfolio updatedPortfolio = portfolioService.updatePortfolio(id, portfolio);
//        return ResponseEntity.ok(updatedPortfolio);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePortfolio(@PathVariable int id) {
//        portfolioService.deletePortfolio(id);
//        return ResponseEntity.noContent().build();
//    }
//    
//}
@RestController
@CrossOrigin("*")
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @PostMapping("/create")
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        System.out.println(portfolio);
        Portfolio createdPortfolio = portfolioService.savePortfolio(portfolio);
        return ResponseEntity.ok(createdPortfolio);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable int id) {
        Optional<Portfolio> portfolio = portfolioService.findPortfolioById(id);
        return portfolio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Portfolio>> getAllPortfolios() {
        List<Portfolio> portfolios = portfolioService.findAllPortfolios();
        return ResponseEntity.ok(portfolios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable int id, @RequestBody Portfolio portfolio) {
        Portfolio updatedPortfolio = portfolioService.updatePortfolio(id, portfolio);
        return ResponseEntity.ok(updatedPortfolio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable int id) {
        portfolioService.deletePortfolio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Portfolio>> getPortfoliosByUserId(@PathVariable int userId) {
        List<Portfolio> portfolios = portfolioService.findPortfoliosByUserId(userId);
        return ResponseEntity.ok(portfolios);
    }
}

