package com.exemple.controller;

import com.exemple.entity.Produit;
import com.exemple.service.InterfaceProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/produits")
public class ProduitController {

    private InterfaceProduitService interfaceProduitService;

    @GetMapping
    public String getAllProduits(Model model)
    {
        List<Produit> produits = interfaceProduitService.getProduits();
        model.addAttribute("produits", produits);
        return "/produits/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model)
    {
        model.addAttribute("produit", new Produit());
        return "/produits/create";
    }

    @PostMapping("/add")
    public String addProduit(@ModelAttribute("produit") Produit produit)
    {
        interfaceProduitService.addProduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model)
    {
        Produit produit = interfaceProduitService.getById(id);
        model.addAttribute("produit", produit);
        return "/produits/edit";
    }

    @PostMapping("/update")
    public String updateProduit(@ModelAttribute("produit") Produit produit)
    {
        interfaceProduitService.updateProduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable Long id)
    {
        interfaceProduitService.delete(id);
        return "redirect:/produits";
    }
}
