package com.esprit.tn.testspring.RestController;


import com.esprit.tn.testspring.Entities.CategorieClient;
import com.esprit.tn.testspring.Entities.Client;
import com.esprit.tn.testspring.Service.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    IClientService iClientService;

    @GetMapping
    public List<Client> retrieveAllClients() {
        return iClientService.retrieveAllClients();
    }

    @PostMapping
    public Client addClient(@RequestBody Client c) {
        return iClientService.addClient(c);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        iClientService.deleteClient(id);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client c) {
        return iClientService.updateClient(c);
    }

    @GetMapping("/{id}")
    public Client retrieveClient(@PathVariable Long id) {
        return iClientService.retrieveClient(id);
    }

    @GetMapping("/chiffre/{startDate}/{endDate}/{categorieClient}")
    public float getChiffreAffaireParCategorieClient(@PathVariable CategorieClient categorieClient, @PathVariable@DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,@PathVariable@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return iClientService.getChiffreAffaireParCategorieClient(categorieClient,startDate,endDate);
    }
    }




