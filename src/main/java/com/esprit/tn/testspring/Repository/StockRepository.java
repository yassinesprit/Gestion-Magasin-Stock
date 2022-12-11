package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.Client;
import com.esprit.tn.testspring.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Long> {
    @Query("SELECT e FROM Stock e WHERE e.qteStock <=e.qteMin")
    List<Stock> findByQteStockMin();
}
