package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.Client;
import com.esprit.tn.testspring.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
