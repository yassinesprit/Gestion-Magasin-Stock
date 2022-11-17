package com.esprit.tn.testspring.Service;

import com.esprit.tn.testspring.Entities.Facture;
import com.esprit.tn.testspring.Repository.ClientRepository;
import com.esprit.tn.testspring.Repository.FactureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class FactureServiceImpl implements IFactureService{

    FactureRepository factureRepository;
    ClientRepository clientRepository;

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        Facture f = retrieveFacture(id);
       // if (f!=null && !f.isActive()){
            f.setActive(false);

        //}
        factureRepository.save(f);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {

        return factureRepository.findByClientIdClient(idClient);
    }
}
