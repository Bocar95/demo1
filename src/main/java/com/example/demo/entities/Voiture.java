package com.example.demo.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "voiture")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_voiture")
    private String typeVoiture;

    @Column(name = "matricule_voiture")
    private String matriculeVoiture;

    @Column(name = "date_heure_depart")
    private LocalDateTime dateHeureDepart;

    @Column(name = "destination_voiture")
    private String destinationVoiture;

    @OneToMany(mappedBy = "voiture")
    private List<Passager> listPassagers;

    @OneToOne(mappedBy = "chauffeur", cascade = CascadeType.MERGE)
    private Chauffeur chauffeur;
    
}
