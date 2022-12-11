package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.Client;
import com.esprit.tn.testspring.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

}
