package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.Client;
import com.esprit.tn.testspring.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
