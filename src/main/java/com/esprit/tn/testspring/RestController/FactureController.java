package com.esprit.tn.testspring.RestController;

import com.esprit.tn.testspring.Entities.CategorieClient;
import com.esprit.tn.testspring.Entities.Client;
import com.esprit.tn.testspring.Entities.Facture;
import com.esprit.tn.testspring.Repository.FactureRepository;
import com.esprit.tn.testspring.Service.IFactureService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/facture")
public class FactureController {


    IFactureService iFactureService;
    FactureRepository factureRepository;

    @GetMapping
    public List<Facture> retrieveAllFactures(){
        return iFactureService.retrieveAllFactures();
    }

    @PutMapping("/{id}")
    public void cancelFacture(@PathVariable Long id){
         iFactureService.cancelFacture(id);
    }

    @GetMapping("/{id}")
    public Facture retrieveFacture(@PathVariable Long id){
        return iFactureService.retrieveFacture(id);
    }

    @GetMapping("/client/{idClient}")
    public List<Facture> getFacturesByClient(Long idClient) {
        return iFactureService.getFacturesByClient(idClient);
    }
/*
    @GetMapping("/test/{d1}/{d2}")
    public List<Facture> findByDateFactureBetween(@PathVariable CategorieClient c, @PathVariable@DateTimeFormat(pattern="yyyy-MM-dd")Date d1, @PathVariable@DateTimeFormat(pattern="yyyy-MM-dd") Date d2){
        return factureRepository.findByClientCategorieClientAndDateFactureBetween(c,d1,d2);
    }
*/

}
