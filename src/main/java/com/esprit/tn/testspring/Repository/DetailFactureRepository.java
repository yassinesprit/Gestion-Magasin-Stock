package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.DetailFacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailFactureRepository extends JpaRepository<DetailFacture,Long> {
}
