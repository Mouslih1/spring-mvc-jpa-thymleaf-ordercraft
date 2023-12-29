package com.exemple.service.impl;

import com.exemple.entity.Produit;
import com.exemple.repository.InterfaceProduitRepository;
import com.exemple.service.InterfaceProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitService implements InterfaceProduitService {

    private InterfaceProduitRepository interfaceProduitRepository;

    @Override
    public List<Produit> getProduits()
    {
        return interfaceProduitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit produit)
    {
        return interfaceProduitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return interfaceProduitRepository.save(produit);
    }

    @Override
    public void delete(Long id)
    {
        interfaceProduitRepository.deleteById(id);
    }

    @Override
    public Produit getById(Long id)
    {
        return interfaceProduitRepository.findById(id).orElse(null);
    }
}
