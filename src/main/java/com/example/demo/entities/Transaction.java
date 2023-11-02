package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_transaction")
    private LocalDateTime dateTransaction;

    @Column(name = "prenom_client")
    private String prenomClient;

    @Column(name = "nom_client")
    private String nomClient;

    @Column(name = "statut_transaction")
    private String statutTransaction;

}
