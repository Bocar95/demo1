package com.example.demo.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.entities.Bagage;

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
public class BagageDto {

    private Long id;
    private String libelleBagage;
    private String typeBagage;
    @NotNull(message = "La quantité de bagage est obligatoire")
    @Min(value = 0, message = "La quantité de bagage doit être d'au moins 0")
    private Integer quantiteBagage;
    @NotEmpty(message = "Le passager est obligatoire")
    private PassagerResumeDto passagerResumeDto;

    public static BagageDto fromEntity(Bagage bagage){
        if(bagage == null){
            return null;
        }
        return BagageDto.builder()
            .id(bagage.getId())
            .libelleBagage(bagage.getLibelleBagage())
            .typeBagage(bagage.getTypeBagage())
            .quantiteBagage(bagage.getQuantiteBagage())
            .passagerResumeDto(PassagerResumeDto.fromEntity(bagage.getPassager()))
            .build();
    }

    public static List<BagageDto> fromEntities(List<Bagage> bagages){
        if(bagages.isEmpty() || bagages == null){
            return Collections.emptyList();
        }
        return bagages.stream().map(BagageDto::fromEntity).collect(Collectors.toList());
    }

    public static Bagage toEntity(BagageDto bagageDto){
        if(bagageDto == null){
            return null;
        }
        Bagage bagage = new Bagage();
        bagage.setId(bagageDto.getId());
        bagage.setLibelleBagage(bagageDto.getLibelleBagage());
        bagage.setTypeBagage(bagageDto.getTypeBagage());
        bagage.setQuantiteBagage(bagageDto.getQuantiteBagage());
        bagage.setPassager(PassagerResumeDto.toEntity(bagageDto.getPassagerResumeDto()));
        return bagage;
    }

    public static List<Bagage> toEntities(List<BagageDto> bagageDtos){
        if(bagageDtos.isEmpty() || bagageDtos == null){
            return Collections.emptyList();
        }
        return bagageDtos.stream().map(BagageDto::toEntity).collect(Collectors.toList());
    }
    
}
