package com.esprit.tn.testspring.RestController;

import com.esprit.tn.testspring.Entities.Produit;
import com.esprit.tn.testspring.Service.IProduitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produit")
public class ProduitController {

    IProduitService iProduitService;

    @GetMapping
    public List<Produit> retrieveAllProduits(){
        return iProduitService.retrieveAllProduits();
    }

    @PostMapping("/{idRayon}/{idStock}")
    public Produit addProduit(@RequestBody Produit p,@PathVariable Long idRayon,@PathVariable Long idStock){
        return iProduitService.addProduit(p,idRayon,idStock);
    }

    @GetMapping("/{id}")
    public Produit retrieveProduit(@PathVariable Long id){
        return iProduitService.retrieveProduit(id);
    }

    @PutMapping("/assign/{idProduit}/{idStock}")
    public void assignProduitToStock(@PathVariable Long idProduit,@PathVariable Long idStock){
        iProduitService.assignProduitToStock(idProduit,idStock);
    }

    @PutMapping("/assignf/{fournisseurId}/{produitId}")
    public void assignFournisseurToProduit(@PathVariable Long fournisseurId,@PathVariable Long produitId){
        iProduitService.assignFournisseurToProduit(fournisseurId,produitId);
    }

}
