package com.esprit.tn.testspring.Repository;


import com.esprit.tn.testspring.Entities.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailProduitRepository extends JpaRepository<DetailProduit,Long> {
}
