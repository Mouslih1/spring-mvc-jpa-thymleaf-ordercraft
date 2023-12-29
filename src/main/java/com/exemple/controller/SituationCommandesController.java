package com.exemple.controller;

import com.exemple.entity.Client;
import com.exemple.entity.Commande;
import com.exemple.entity.CommandeProduits;
import com.exemple.entity.Produit;
import com.exemple.service.InterfaceClientService;
import com.exemple.service.InterfaceCommandeProduitsService;
import com.exemple.service.InterfaceCommandeService;
import com.exemple.service.InterfaceProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/situation_commandes")
public class SituationCommandesController {

    private InterfaceCommandeService interfaceCommandeService;
    private InterfaceClientService interfaceClientService;
    private InterfaceProduitService interfaceProduitService;
    private InterfaceCommandeProduitsService interfaceCommandeProduitsService;

    @GetMapping
    public String situtationCommandes(Model model)
    {
        List<Produit> produits = interfaceProduitService.getProduits();
        List<Client> clients = interfaceClientService.getClients();
        List<CommandeProduits> commandeProduits = interfaceCommandeProduitsService.getCommandeProduits();
        List<Commande> commandes = interfaceCommandeService.getCommandes();
        model.addAttribute("produits",produits);
        model.addAttribute("clients", clients);
        model.addAttribute("commandeProduits",commandeProduits);
        model.addAttribute("commandes", commandes);
        return "/situation_commande/situation_commande";
    }
}
