package com.exemple.repository;

import com.exemple.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceProduitRepository extends JpaRepository<Produit,Long> {
}
