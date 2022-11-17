package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
