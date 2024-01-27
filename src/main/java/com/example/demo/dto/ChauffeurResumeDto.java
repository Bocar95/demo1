package com.example.demo.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Chauffeur;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChauffeurResumeDto {

    private Long id;
    private String prenomChauffeur;
    private String nomChauffeur;
    private Integer telephoneChauffeur;
    private Integer numeroPermisChauffeur;

    public static ChauffeurResumeDto fromEntity(Chauffeur chauffeur){
        if(chauffeur == null){
            return null;
        }
        return ChauffeurResumeDto.builder()
            .id(chauffeur.getId())
            .prenomChauffeur(chauffeur.getPrenomChauffeur())
            .nomChauffeur(chauffeur.getNomChauffeur())
            .telephoneChauffeur(chauffeur.getTelephoneChauffeur())
            .numeroPermisChauffeur(chauffeur.getNumeroPermisChauffeur())
            .build();
    }

    public static List<ChauffeurResumeDto> fromEntities(List<Chauffeur> chauffeurs){
        if(chauffeurs.isEmpty() || chauffeurs == null){
            return Collections.emptyList();
        }
        return chauffeurs.stream().map(ChauffeurResumeDto::fromEntity).collect(Collectors.toList());
    }

    public static Chauffeur toEntity(ChauffeurResumeDto chauffeurResumeDto){
        if(chauffeurResumeDto == null){
            return null;
        }
        Chauffeur chauffeur = new Chauffeur();
        chauffeur.setId(chauffeurResumeDto.getId());
        chauffeur.setPrenomChauffeur(chauffeurResumeDto.getPrenomChauffeur());
        chauffeur.setNomChauffeur(chauffeurResumeDto.getNomChauffeur());
        chauffeur.setTelephoneChauffeur(chauffeurResumeDto.getTelephoneChauffeur());
        chauffeur.setNumeroPermisChauffeur(chauffeurResumeDto.getNumeroPermisChauffeur());

        return chauffeur;
    }

    public static List<Chauffeur> toEntities(List<ChauffeurResumeDto> chauffeurResumeDtos){
        if(chauffeurResumeDtos.isEmpty() || chauffeurResumeDtos == null){
            return Collections.emptyList();
        }
        return chauffeurResumeDtos.stream().map(ChauffeurResumeDto::toEntity).collect(Collectors.toList());
    }
   
}
