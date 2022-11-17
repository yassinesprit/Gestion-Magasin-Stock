package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {
    public List<Facture> findByClientIdClient(Long id);
}
