package com.example.demo.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entities.Passager;

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
public class PassagerDto {
    
    private Long id;
    private String prenomPassager;
    private String nomPassager;
    private String adressePassager;
    private Integer telephonePassager;
    private Integer cniPassager;
    private List<BagageResumeDto> listBagageResumeDtos;
    private VoitureResumeDto voitureResumeDto;


    public static PassagerDto fromEntity(Passager passager){
        if(passager == null){
            return null;
        }
        return PassagerDto.builder()
            .id(passager.getId())
            .prenomPassager(passager.getPrenomPassager())
            .nomPassager(passager.getNomPassager())
            .adressePassager(passager.getAdressePassager())
            .telephonePassager(passager.getTelephonePassager())
            .cniPassager(passager.getCniPassager())
            .listBagageResumeDtos(BagageResumeDto.fromEntities(passager.getListBagages()))
            .voitureResumeDto(VoitureResumeDto.fromEntity(passager.getVoiture()))
            .build();
    }

    public static List<PassagerDto> fromEntities(List<Passager> passagers){
        if(passagers.isEmpty() || passagers == null){
            return Collections.emptyList();
        }
        return passagers.stream().map(PassagerDto::fromEntity).collect(Collectors.toList());
    }

    public static Passager toEntity(PassagerDto passagerDto){
        if(passagerDto == null){
            return null;
        }
        Passager passager = new Passager();
        passager.setId(passagerDto.getId());
        passager.setPrenomPassager(passagerDto.getPrenomPassager());
        passager.setNomPassager(passagerDto.getNomPassager());
        passager.setAdressePassager(passagerDto.getAdressePassager());
        passager.setTelephonePassager(passagerDto.getTelephonePassager());
        passager.setCniPassager(passagerDto.getCniPassager());
        passager.setListBagages(BagageResumeDto.toEntities(passagerDto.getListBagageResumeDtos()));
        passager.setVoiture(VoitureResumeDto.toEntity(passagerDto.getVoitureResumeDto()));

        return passager;
    }

    public static List<Passager> toEntities(List<PassagerDto> passagerDtos){
        if(passagerDtos.isEmpty() || passagerDtos == null){
            return Collections.emptyList();
        }
        return passagerDtos.stream().map(PassagerDto::toEntity).collect(Collectors.toList());
    }
       
}
