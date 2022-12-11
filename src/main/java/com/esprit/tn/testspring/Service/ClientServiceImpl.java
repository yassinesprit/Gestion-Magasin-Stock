package com.esprit.tn.testspring.Service;

import com.esprit.tn.testspring.Entities.CategorieClient;
import com.esprit.tn.testspring.Entities.Client;
import com.esprit.tn.testspring.Entities.Facture;
import com.esprit.tn.testspring.Repository.ClientRepository;
import com.esprit.tn.testspring.Repository.FactureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements IClientService{

    ClientRepository clientRepository;
    FactureRepository factureRepository;

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        List<Client> clients = clientRepository.findByCategorieClient(categorieClient);
        float somme=0;
        for (Client c :clients) {
            List<Facture> factures=factureRepository.findByClientAndDateFactureBetween(c,startDate,endDate);
            for (Facture f :factures) {
                somme=somme+ f.getMontantFacture();
            }
        }
        return somme;
    }
}
