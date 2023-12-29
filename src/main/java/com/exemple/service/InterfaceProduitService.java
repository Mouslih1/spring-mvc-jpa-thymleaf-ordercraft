package com.exemple.service;

import com.exemple.entity.Client;
import com.exemple.entity.Produit;

import java.util.List;

public interface InterfaceProduitService {
    List<Produit> getProduits();
    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit);
    void delete(Long id);
    Produit getById(Long id);
}
