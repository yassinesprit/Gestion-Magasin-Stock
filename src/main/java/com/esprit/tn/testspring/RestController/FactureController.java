package com.esprit.tn.testspring.RestController;

import com.esprit.tn.testspring.Entities.Facture;
import com.esprit.tn.testspring.Service.IFactureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/facture")
public class FactureController {


    IFactureService iFactureService;

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


}
