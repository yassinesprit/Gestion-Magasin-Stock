package com.esprit.tn.testspring.Service;

import ch.qos.logback.core.util.FixedDelay;
import com.esprit.tn.testspring.Entities.Produit;
import com.esprit.tn.testspring.Entities.Stock;
import com.esprit.tn.testspring.Repository.ProduitRepository;
import com.esprit.tn.testspring.Repository.StockRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
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

    @Override
    @Scheduled(fixedRate = 1000)
    public String retrieveStatusStock() {
        List<Stock> stocks=stockRepository.findByQteStockMin();
        stocks.stream().forEach(
                (stock -> {
                    log.info(stock.libelleStock+" est en rupture");
                })
        );
        return null;
    }


}
