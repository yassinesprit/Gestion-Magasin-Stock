package com.esprit.tn.testspring.Service;

import com.esprit.tn.testspring.Entities.Stock;

import java.util.List;

public interface IStockService {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);



}
