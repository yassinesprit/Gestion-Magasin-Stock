package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.DetailFacture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DetailFactureRepository extends JpaRepository<DetailFacture,Long> {
    List<DetailFacture> findByProduitIdProduitAndFactureDateFactureBetween(Long idProduit, Date startDate, Date endDate);
}
