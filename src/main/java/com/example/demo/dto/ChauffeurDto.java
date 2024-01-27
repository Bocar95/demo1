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
public class ChauffeurDto {
    
    private Long id;
    private String prenomChauffeur;
    private String nomChauffeur;
    private Integer telephoneChauffeur;
    private Integer numeroPermisChauffeur;
    private VoitureResumeDto voitureResumeDto;


    public static ChauffeurDto fromEntity(Chauffeur chauffeur){
        if(chauffeur == null){
            return null;
        }
        return ChauffeurDto.builder()
            .id(chauffeur.getId())
            .prenomChauffeur(chauffeur.getPrenomChauffeur())
            .nomChauffeur(chauffeur.getNomChauffeur())
            .telephoneChauffeur(chauffeur.getTelephoneChauffeur())
            .numeroPermisChauffeur(chauffeur.getNumeroPermisChauffeur())
            .voitureResumeDto(VoitureResumeDto.fromEntity(chauffeur.getVoiture()))
            .build();
    }

    public static List<ChauffeurDto> fromEntities(List<Chauffeur> chauffeurs){
        if(chauffeurs.isEmpty() || chauffeurs == null){
            return Collections.emptyList();
        }
        return chauffeurs.stream().map(ChauffeurDto::fromEntity).collect(Collectors.toList());
    }

    public static Chauffeur toEntity(ChauffeurDto chauffeurDto){
        if(chauffeurDto == null){
            return null;
        }
        Chauffeur chauffeur = new Chauffeur();
        chauffeur.setId(chauffeurDto.getId());
        chauffeur.setPrenomChauffeur(chauffeurDto.getPrenomChauffeur());
        chauffeur.setNomChauffeur(chauffeurDto.getNomChauffeur());
        chauffeur.setTelephoneChauffeur(chauffeurDto.getTelephoneChauffeur());
        chauffeur.setNumeroPermisChauffeur(chauffeurDto.getNumeroPermisChauffeur());
        chauffeur.setVoiture(VoitureResumeDto.toEntity(chauffeurDto.getVoitureResumeDto()));

        return chauffeur;
    }

    public static List<Chauffeur> toEntities(List<ChauffeurDto> chauffeurDtos){
        if(chauffeurDtos.isEmpty() || chauffeurDtos == null){
            return Collections.emptyList();
        }
        return chauffeurDtos.stream().map(ChauffeurDto::toEntity).collect(Collectors.toList());
    }
   
}
