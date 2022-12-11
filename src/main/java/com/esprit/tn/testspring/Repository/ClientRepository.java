package com.esprit.tn.testspring.Repository;

import com.esprit.tn.testspring.Entities.CategorieClient;
import com.esprit.tn.testspring.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findByCategorieClient(CategorieClient categorie );

}
