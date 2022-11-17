package com.esprit.tn.testspring.RestController;

import com.esprit.tn.testspring.Entities.Stock;
import com.esprit.tn.testspring.Service.IStockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/stock")
public class StockController {

    IStockService iStockService;


    @GetMapping
    public List<Stock> retrieveAllStocks() {
        return iStockService.retrieveAllStocks();
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock s) {
        return iStockService.addStock(s);
    }

    @PutMapping
    public Stock updateStock(@RequestBody Stock u) {
        return iStockService.updateStock(u);
    }

    @GetMapping("/{id}")
    public Stock retrieveStock(@PathVariable Long id) {
        return iStockService.retrieveStock(id);
    }
}
