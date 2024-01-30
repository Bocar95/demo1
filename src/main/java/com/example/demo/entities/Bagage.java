package com.example.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "bagage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bagage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle_bagage")
    private String libelleBagage;

    @Column(name = "type_bagage")
    private String typeBagage;

    @Column(name = "quantite_bagage")
    private Integer quantiteBagage;

    @ManyToOne
    @JoinColumn(name = "id_passager", nullable = true)
    private Passager passager;
    
}
