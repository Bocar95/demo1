package com.example.demo.dto;

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
public class VoitureResumeDto {
    
    private Long id;
    private String typeVoiture;
    private String matriculeVoiture;
    private String destinationVoiture;
    
    public static VoitureResumeDto fromEntity(Voiture voiture){
        if(voiture == null){
            return null;
        }
        return VoitureResumeDto.builder()
            .id(voiture.getId())
            .typeVoiture(voiture.getTypeVoiture())
            .matriculeVoiture(voiture.getMatriculeVoiture())
            .destinationVoiture(voiture.getDestinationVoiture())
            .build();
    }

    public static List<VoitureResumeDto> fromEntities(List<Voiture> voitures){
        if(voitures.isEmpty() || voitures == null){
            return Collections.emptyList();
        }
        return voitures.stream().map(VoitureResumeDto::fromEntity).collect(Collectors.toList());
    }

    public static Voiture toEntity(VoitureResumeDto voitureResumeDto){
        if(voitureResumeDto == null){
            return null;
        }
        Voiture voiture = new Voiture();
        voiture.setId(voitureResumeDto.getId());
        voiture.setTypeVoiture(voitureResumeDto.getTypeVoiture());
        voiture.setMatriculeVoiture(voitureResumeDto.getMatriculeVoiture());
        voiture.setDestinationVoiture(voitureResumeDto.getDestinationVoiture());

        return voiture;
    }

    public static List<Voiture> toEntities(List<VoitureResumeDto> voitureResumeDtos){
        if(voitureResumeDtos.isEmpty() || voitureResumeDtos == null){
            return Collections.emptyList();
        }
        return voitureResumeDtos.stream().map(VoitureResumeDto::toEntity).collect(Collectors.toList());
    }
       
}
