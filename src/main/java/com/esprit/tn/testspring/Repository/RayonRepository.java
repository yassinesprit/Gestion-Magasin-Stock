package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.Client;
import com.esprit.tn.testspring.Entities.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RayonRepository extends JpaRepository<Rayon,Long> {
}
