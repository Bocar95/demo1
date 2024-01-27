package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Voiture;

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
public class VoitureDto {
    
    private Long id;
    private String typeVoiture;
    private String matriculeVoiture;
    private LocalDateTime dateHeureDepart;
    private String destinationVoiture;
    private List<PassagerResumeDto> listPassagerResumeDtos;
    private ChauffeurResumeDto chauffeurResumeDto;
    
    public static VoitureDto fromEntity(Voiture voiture){
        if(voiture == null){
            return null;
        }
        return VoitureDto.builder()
            .id(voiture.getId())
            .typeVoiture(voiture.getTypeVoiture())
            .matriculeVoiture(voiture.getMatriculeVoiture())
            .dateHeureDepart(voiture.getDateHeureDepart())
            .destinationVoiture(voiture.getDestinationVoiture())
            .listPassagerResumeDtos(PassagerResumeDto.fromEntities(voiture.getListPassagers()))
            .chauffeurResumeDto(ChauffeurResumeDto.fromEntity(voiture.getChauffeur()))
            .build();
    }

    public static List<VoitureDto> fromEntities(List<Voiture> voitures){
        if(voitures.isEmpty() || voitures == null){
            return Collections.emptyList();
        }
        return voitures.stream().map(VoitureDto::fromEntity).collect(Collectors.toList());
    }

    public static Voiture toEntity(VoitureDto voitureDto){
        if(voitureDto == null){
            return null;
        }
        Voiture voiture = new Voiture();
        voiture.setId(voitureDto.getId());
        voiture.setTypeVoiture(voitureDto.getTypeVoiture());
        voiture.setMatriculeVoiture(voitureDto.getMatriculeVoiture());
        voiture.setDateHeureDepart(voitureDto.getDateHeureDepart());
        voiture.setDestinationVoiture(voitureDto.getDestinationVoiture());
        voiture.setListPassagers(PassagerResumeDto.toEntities(voitureDto.getListPassagerResumeDtos()));
        voiture.setChauffeur(ChauffeurResumeDto.toEntity(voitureDto.getChauffeurResumeDto()));

        return voiture;
    }

    public static List<Voiture> toEntities(List<VoitureDto> voitureDtos){
        if(voitureDtos.isEmpty() || voitureDtos == null){
            return Collections.emptyList();
        }
        return voitureDtos.stream().map(VoitureDto::toEntity).collect(Collectors.toList());
    }

}
