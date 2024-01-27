package com.example.demo.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
public class BagageResumeDto {
    
    private Long id;
    private String libelleBagage;
    private String typeBagage;
    private Integer quantiteBagage;

    public static BagageResumeDto fromEntity(Bagage bagage){
        if(bagage == null){
            return null;
        }
        return BagageResumeDto.builder()
            .id(bagage.getId())
            .libelleBagage(bagage.getLibelleBagage())
            .typeBagage(bagage.getTypeBagage())
            .quantiteBagage(bagage.getQuantiteBagage())
            .build();
    }

    public static List<BagageResumeDto> fromEntities(List<Bagage> bagages){
        if(bagages.isEmpty() || bagages == null){
            return Collections.emptyList();
        }
        return bagages.stream().map(BagageResumeDto::fromEntity).collect(Collectors.toList());
    }

    public static Bagage toEntity(BagageResumeDto bagageResumeDto){
        if(bagageResumeDto == null){
            return null;
        }
        Bagage bagage = new Bagage();
        bagage.setId(bagageResumeDto.getId());
        bagage.setLibelleBagage(bagageResumeDto.getLibelleBagage());
        bagage.setTypeBagage(bagageResumeDto.getTypeBagage());
        bagage.setQuantiteBagage(bagageResumeDto.getQuantiteBagage());
        return bagage;
    }

    public static List<Bagage> toEntities(List<BagageResumeDto> bagageResumeDtos){
        if(bagageResumeDtos.isEmpty() || bagageResumeDtos == null){
            return Collections.emptyList();
        }
        return bagageResumeDtos.stream().map(BagageResumeDto::toEntity).collect(Collectors.toList());
    }
    
}
