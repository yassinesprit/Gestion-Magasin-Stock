package com.esprit.tn.testspring.Service;

import com.esprit.tn.testspring.Entities.*;
import com.esprit.tn.testspring.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements IProduitService{

    ProduitRepository produitRepository;
    RayonRepository rayonRepository;
    StockRepository stockRepository;
    FournisseurRepository fournisseurRepository;
    DetailFactureRepository detailFactureRepository;
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

    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        float brut=0;
        List<DetailFacture> detailFactures=detailFactureRepository.findByProduitIdProduitAndFactureDateFactureBetween(idProduit,startDate,endDate) ;
            for (DetailFacture d:detailFactures)
            {
                brut=brut+(d.getProduit().getPrixProduit()*d.getQte());
            }
        return brut;
    }
}
