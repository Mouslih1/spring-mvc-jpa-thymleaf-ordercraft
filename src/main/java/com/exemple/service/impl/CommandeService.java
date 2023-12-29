package com.exemple.service.impl;

import com.exemple.entity.Commande;
import com.exemple.repository.InterfaceCommandeRepository;
import com.exemple.service.InterfaceCommandeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommandeService implements InterfaceCommandeService {

    private InterfaceCommandeRepository interfaceCommandeRepository;

    @Override
    public Commande addCommande(Commande commande)
    {
        return interfaceCommandeRepository.save(commande);
    }

    @Override
    public Commande getById(Long id)
    {
        return interfaceCommandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commande> getCommandes() {
        return interfaceCommandeRepository.findAll();
    }
}
