package com.example.demo.entities;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "passager")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passager {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prenom_passager")
    private String prenomPassager;

    @Column(name = "nom_passager")
    private String nomPassager;

    @Column(name = "adresse_passager")
    private String adressePassager;

    @Column(name = "telephone_passager")
    private Integer telephonePassager;

    @Column(name = "cni_passager")
    private Integer cniPassager;

    @OneToMany(mappedBy = "passager")
    private List<Bagage> listBagages;

    @ManyToOne
    @JoinColumn(name = "id_voiture", nullable = true)
    private Voiture voiture;

}
