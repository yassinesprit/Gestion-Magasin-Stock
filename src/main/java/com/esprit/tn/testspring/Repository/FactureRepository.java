package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.CategorieClient;
import com.esprit.tn.testspring.Entities.Client;
import com.esprit.tn.testspring.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {
    public List<Facture> findByClientIdClient(Long id);
    public List<Facture> findByClientAndDateFactureBetween(Client c, Date d1, Date d2);
}
