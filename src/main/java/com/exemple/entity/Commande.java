package com.exemple.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address_livraison;
    private LocalDate date_creation;

    @Enumerated(EnumType.STRING)
    private Etat etat_commande;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
