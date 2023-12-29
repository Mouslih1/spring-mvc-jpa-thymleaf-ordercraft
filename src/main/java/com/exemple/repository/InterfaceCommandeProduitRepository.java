package com.exemple.repository;

import com.exemple.entity.CommandeProduits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceCommandeProduitRepository extends JpaRepository<CommandeProduits,Long> {
}
