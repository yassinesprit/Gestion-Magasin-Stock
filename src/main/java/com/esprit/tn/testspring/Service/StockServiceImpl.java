package com.esprit.tn.testspring.Service;

import com.esprit.tn.testspring.Entities.Produit;
import com.esprit.tn.testspring.Entities.Stock;
import com.esprit.tn.testspring.Repository.ProduitRepository;
import com.esprit.tn.testspring.Repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StockServiceImpl implements IStockService{

    StockRepository stockRepository;
    ProduitRepository produitRepository;

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        return stockRepository.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        return stockRepository.save(u);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }


}
