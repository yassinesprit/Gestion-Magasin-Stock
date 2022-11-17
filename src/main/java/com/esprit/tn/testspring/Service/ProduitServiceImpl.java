package com.esprit.tn.testspring.Service;

import com.esprit.tn.testspring.Entities.Fournisseur;
import com.esprit.tn.testspring.Entities.Produit;
import com.esprit.tn.testspring.Entities.Rayon;
import com.esprit.tn.testspring.Entities.Stock;
import com.esprit.tn.testspring.Repository.FournisseurRepository;
import com.esprit.tn.testspring.Repository.ProduitRepository;
import com.esprit.tn.testspring.Repository.RayonRepository;
import com.esprit.tn.testspring.Repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements IProduitService{

    ProduitRepository produitRepository;
    RayonRepository rayonRepository;
    StockRepository stockRepository;
    FournisseurRepository fournisseurRepository;
    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    @Transactional
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
        Rayon r = rayonRepository.findById(idRayon).orElse(null);
        Stock s = stockRepository.findById(idStock).orElse(null);

        if (p!=null&& r!=null && s!=null ){
            p.setRayon(r);
            p.setStock(s);
        return produitRepository.save(p);
        }
        return null;
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = produitRepository.findById(idProduit).orElse(null);
        Stock s = stockRepository.findById(idStock).orElse(null);

        if (p!=null && s!=null){
            p.setStock(s);
        }
        produitRepository.save(p);
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Fournisseur f = fournisseurRepository.findById(fournisseurId).orElse(null);
        Produit p = produitRepository.findById(produitId).orElse(null);

        if (f!=null && p!=null){
            p.getFournisseurs().add(f);
        }
        produitRepository.save(p);
    }
}
