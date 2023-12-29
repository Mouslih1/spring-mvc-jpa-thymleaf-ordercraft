package com.exemple.repository;

import com.exemple.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceCommandeRepository extends JpaRepository<Commande,Long> {
}
